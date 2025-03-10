import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String string_num = Integer.toString(n);
        
        for(int i=0; i<string_num.length(); i++){
            answer += string_num.charAt(i) - '0';
        }

        return answer;
    }
}