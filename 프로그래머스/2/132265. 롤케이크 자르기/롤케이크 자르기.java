import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        int start = 0;
        int end = start + 1;
        
        Map<Integer, Integer> cake1 = new HashMap<>();
        Map<Integer, Integer> cake2 = new HashMap<>();
        
        cake1.put(topping[0], 1);
        for(int i=1; i<topping.length; i++){
            cake2.put(topping[i], cake2.getOrDefault(topping[i], 0) + 1);
        }
        
        if (cake1.size() == cake2.size()) answer ++;
        for(int i=1; i<topping.length; i++){
            cake1.put(topping[i], cake1.getOrDefault(topping[i], 0) + 1);
            cake2.put(topping[i], cake2.getOrDefault(topping[i], 1) - 1);
            if (cake2.get(topping[i]) == 0) cake2.remove(topping[i]);
            if (cake1.size() == cake2.size()) answer ++;
        }
    
        return answer;
    }
}