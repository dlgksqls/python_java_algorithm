import java.util.*;

class Solution {
    public ArrayList solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        
        while(count <= progresses.length){
            for(int i=0; i<progresses.length; i++){
                progresses[i] += speeds[i]; 
                if (progresses[i] >= 100){
                    stack.push(i);
                }
            }
            
            int pop_count = 0;
            while(!stack.isEmpty()){
                stack.pop();
                pop_count ++;
            }
            answer.add(pop_count);
            count += pop_count;
        }
        return answer;
    }
}