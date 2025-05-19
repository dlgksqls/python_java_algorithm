class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        int j = 1;
        int num = 0;
        
        while(true){
            String str = Integer.toString(num, n).toUpperCase();
            
            for(char c : str.toCharArray()){
                if (j == m+1){
                    j = 1;
                }
                if (j == p){
                    answer += c;
                }
                if (answer.length() == t){
                    return answer;
                }
                j ++;
            }
            num ++;
        }
    }
}