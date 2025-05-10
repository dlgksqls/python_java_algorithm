class Solution {
    public String solution(String s) {
        String answer = "";
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String[] array_str = s.split(" ");
        
        for(int i=0; i<array_str.length; i++){
            max = Math.max(max, Integer.parseInt(array_str[i]));
            min = Math.min(min, Integer.parseInt(array_str[i]));
        }
        
        answer += min + " " + max;
        return answer;
    }
}