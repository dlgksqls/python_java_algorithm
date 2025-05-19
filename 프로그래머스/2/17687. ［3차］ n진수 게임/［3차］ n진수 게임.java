class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        int j = 1;
        int num = 0;
        
        while(true){
            // String str = Integer.toString(num, n);
            String str = convert(num, n).toUpperCase();
            
            for(char c : str.toCharArray()){
                if (p == j){
                    answer += c;
                    p += m;
                }
                if (answer.length() == t){
                    return answer;
                }
                j ++;
            }
            num ++;
        }
    }
    
    String convert(int num, int base){
        if (num == 0) return "0";

        String str = "";
        while(num > 0){
            int temp = num % base;
            if (temp >= 10){
                str = (char)(temp - 10 + 'a') + str;
            }
            else {
                str = (char)(temp + '0') + str;
            }
            num /= base;
        }
        return str;
    }
}