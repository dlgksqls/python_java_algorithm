class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String input = Integer.toString(n, k).toUpperCase();
        
        String tmp = "";
        for(int i=0; i<input.length(); i++){
            char ch = input.charAt(i);
            if (ch == '0'){
                if (!tmp.isEmpty() && isPrime(Long.parseLong(tmp))){
                    answer ++;
                }
                tmp = "";
            }
            else{
                tmp += ch;
            }
        }
        
        if (!tmp.isEmpty() && isPrime(Long.parseLong(tmp))) {
            answer++;
        }
        return answer;
    }
    
    boolean isPrime(long input){
        if (input < 2) return false;
        for(long i=2; i*i<=input; i++){
            if (input % i == 0){
                return false;
            }
        }
        return true;
    }
}