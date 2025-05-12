import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        
        for(int i=1; i<words.length; i++){
            String prev = words[i-1];
            String now = words[i];
            
            if (prev.charAt(prev.length() - 1) != now.charAt(0) || set.contains(now)){
                return new int[] {(i % n) + 1, (i / n) + 1};
            }
            set.add(now);
        }
        return new int[] {0, 0};
    }
}