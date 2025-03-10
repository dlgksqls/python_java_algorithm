import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String answer_sub = "";
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '-'){
                answer_sub += '-';
                continue;
            } 
            answer_sub += s.charAt(i);
        }
        
        answer = Integer.valueOf(answer_sub);  
        return answer;
    }
}