import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int tmp = 0;
        
        for(int i=0; i<dartResult.length(); i++){
            if (dartResult.charAt(i) == '1' && dartResult.charAt(i+1) == '0') {
                tmp = 10;
                 i++;
                continue;
            }
            
            char chr = dartResult.charAt(i);
            if ('0' <= chr && chr <= '9') {
                tmp = chr-'0';
                continue;
            }       
        
            else if (chr == 'S') stack.push(tmp);
            else if (chr == 'D') stack.push(tmp * tmp);
            else if (chr == 'T') stack.push(tmp * tmp * tmp);
            else if (chr == '*'){
                if (stack.size() == 1) stack.push(stack.pop() * 2);
                else {
                    int first = stack.pop();
                    int second = stack.pop();
                    
                    stack.push(second * 2);
                    stack.push(first * 2);
                }
            }
            else if (chr == '#'){
                stack.push(stack.pop() * -1);
            }
        }
        
        while(!stack.isEmpty()){
            answer += stack.pop();
        }
        
        return answer;
    }
}