import java.util.*;

class Solution {
    static ArrayList<String> list = new ArrayList<>();
    static char[] words = {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        int answer = 0;
        
        recursion(0, "");
        
        answer = list.indexOf(word);
        return answer;
    }
    
    void recursion(int idx, String str){
        
        list.add(str);
        if (idx == 5){
            return;
        }
        
        for(char chr : words){
            recursion(idx + 1, str + chr);
        }
    }
}