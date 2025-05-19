import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        
        answer[numbers.length - 1] = -1;
        int start = numbers.length - 2;
        
        for(int i = start; i>=0; i--){
            if (numbers[i] < numbers[i+1]){
                stack.push(numbers[i+1]);
                answer[i] = numbers[i+1];
                continue;
            }
            boolean isBig = false;
            while(!stack.isEmpty()){
                int now = stack.peek();
                
                if (now > numbers[i]){
                    answer[i] = now;
                    isBig = true;
                    break;
                }
                else stack.pop();
            }
            if (!isBig){
                answer[i] = -1;
            }
        }
        return answer;
    }
}