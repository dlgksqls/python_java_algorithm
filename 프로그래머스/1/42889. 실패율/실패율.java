import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] num = new int[N+2];
        HashMap<Integer, Float> map = new HashMap<>();
        
        for(int stage : stages){
            num[stage] ++;
        }
        
        int length = stages.length;
        for(int i=1; i<=N; i++){
            if (length == 0){
                map.put(i, 0f);
                continue;
            }
            float fail = (float) num[i] / length;
            map.put(i, fail);
            length -= num[i];
        }
        
        ArrayList<Integer> result = new ArrayList<>(map.keySet());
        result.sort(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return Float.compare(map.get(o2), map.get(o1));
            }
        });

        
        for(int i=0; i<N; i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}