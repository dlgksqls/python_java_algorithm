import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> list = new LinkedList<>();
        
        for(String str : cities){
            String city = str.toLowerCase();
            
            if (cacheSize == 0){
                answer += 5;
            }
            else if (list.contains(city)){
                list.remove(city);
                list.add(city);
                answer += 1;
            }
            else{
                if (list.size() < cacheSize){
                    list.add(city);
                }
                else{
                    list.removeFirst();
                    list.add(city);
                }
                answer += 5;
            }
        }
        
        return answer;
    }
}