class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int check = 1; check <= s.length()/2; check ++){
            String tmp = "";
            String str = s.substring(0, check);
            int count = 1;
            for(int i = check; i < s.length(); i += check){
                String sub = "";
                for(int j = i; j < i + check; j ++){
                    if (j < s.length()){
                        sub += s.charAt(j);
                    }
                }
                if (str.equals(sub)) {
                    count ++;
                    continue;
                }
                else{
                    if (count >= 2){
                    tmp += count + str;
                    }
                    else{
                        tmp += str;
                    }
                    str = sub;
                    count = 1;
                }
            }
            if (count >= 2){
                tmp += count + str;
            }
            else{
                tmp += str;
            }
            answer = Math.min(answer, tmp.length());
        }
        return answer;
    }
}