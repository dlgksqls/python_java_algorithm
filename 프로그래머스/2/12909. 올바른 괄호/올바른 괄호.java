import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack();
        
        for(int i=0; i<s.length(); i++){
            if (s.charAt(i) == ')'){
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        
        if (!stack.isEmpty()) return false;

        return answer;
    }
}