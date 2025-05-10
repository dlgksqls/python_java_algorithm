class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int count_0 = 0;
        int count_convert = 0;
        
        while(s.length() > 1){
            String tmp = "";
            for(int i=0; i<s.length(); i++){
                if (s.charAt(i) == '0'){
                    count_0 ++;
                    continue;
                }
                tmp += s.charAt(i);
            }
            
            s = convert(tmp.length());
            count_convert ++;
        }
        
        answer[0] = count_convert;
        answer[1] = count_0;
        return answer;
    }
    
    public String convert(int length){
        return Integer.toBinaryString(length);
    }
}