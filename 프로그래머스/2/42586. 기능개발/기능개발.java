import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<speeds.length; i++){
            int remain = 100 - progresses[i];
            int day = (int) Math.ceil((double) remain / speeds[i]);
            queue.add(day);
        }
        
        while(!queue.isEmpty()){
            int current = queue.poll();
            int count = 1;
            
            while(!queue.isEmpty() && current >= queue.peek()){
                queue.poll();
                count ++;
            }
            
            answer.add(count);
        }
        return answer;
    }
}