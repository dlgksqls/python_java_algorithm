import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<want.length; i++){
            map.put(want[i], number[i]);    
        }
        
        for(int i=0; i<=discount.length-10; i++){
            Map<String, Integer> map_copy = new HashMap<>(map);
            for(int j=i; j<i+10; j++){
                if (map_copy.containsKey(discount[j])){
                    if (map_copy.get(discount[j]) - 1 <= 0){
                        map_copy.remove(discount[j]);
                    }
                    else{
                        map_copy.put(discount[j], map_copy.get(discount[j]) - 1);
                    }
                }
            }
            if (map_copy.isEmpty()) answer ++;
        }
        return answer;
    }
}