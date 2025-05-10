import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        Stack<Character> stack = new Stack<>();
    
        for(int i=0; i<s.length(); i++){
            char now = s.charAt(i);
            if (stack.isEmpty()){
                stack.add(now);
            }
            else if (stack.peek() == now){
                stack.pop();
            }
            else {
                stack.push(now);
            }
        }
        
        if (stack.isEmpty()) return 1;
        else return 0;
    }
}