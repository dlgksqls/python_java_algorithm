class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        
        for(int width=3; width <= total; width++){
            if (total % width != 0) continue;
            
            int height = total/width;
            if (width < height) continue;
            
            int brownCount = (width * 2) + (height - 2) * 2;
            int yellowCount = (width - 2) * (height - 2);
            
            if (brownCount == brown && yellowCount == yellow){
                return new int[] {width, height};
            }
        }
        return null;
    }
}