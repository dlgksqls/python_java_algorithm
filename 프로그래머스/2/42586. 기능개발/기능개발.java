import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        int day = 0;
        
        int count = 0;
        while(count < speeds.length){
            for(int i=0; i<speeds.length; i++){
                if (progresses[i] < 100){
                    progresses[i] += speeds[i];
                }
            }    
            int add_count = 0;
            while(day < speeds.length && progresses[day] >= 100){
                day ++;
                add_count ++;
                count ++;
            }
            if (add_count != 0){
                list.add(add_count);
            }
        }
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}