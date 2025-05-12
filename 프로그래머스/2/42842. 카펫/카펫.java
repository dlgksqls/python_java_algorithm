class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int total = brown + yellow;
        
        for(int height=3; height <= total/height; height++){
            int width = total/height;
            
            if (total % height == 0){
                int inWidth = width - 2;
                int inHeight = height - 2;
                
                if (inWidth * inHeight == yellow){
                    return new int[] {width, height};
                }
            }
        }
        return null;
    }
}