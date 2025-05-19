class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String game = "";
        int num = 0;
        
        while (game.length() < t * m) {
            game += Integer.toString(num ++, n).toUpperCase();
        }
        
        for(int i=p-1; answer.length()<t; i+=m){
            answer += game.charAt(i);
        }
        return answer;
    }
}