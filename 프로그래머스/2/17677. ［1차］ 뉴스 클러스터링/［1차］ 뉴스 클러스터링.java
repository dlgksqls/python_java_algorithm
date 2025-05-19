import java.util.*;
import java.util.regex.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        
        for(int i=0; i<str1.length()-1; i++){
            String word = str1.substring(i, i+2);
            if (Pattern.matches("^[a-zA-Z]*$", word)){
                String upper = word.toUpperCase();
                list1.add(upper);
            }
        }
        
        for(int i=0; i<str2.length()-1; i++){
            String word = str2.substring(i, i+2);
            if (Pattern.matches("^[a-zA-Z]*$", word)){
                String upper = word.toUpperCase();
                list2.add(upper);
            }
        }
        
        int inner = 0;
        for(String str : list1){
            if (list2.contains(str)){
                list2.remove(str);
                inner ++;
            }
        }
        
        int sum = list1.size() + list2.size();
        
        if (sum == 0){
            if (str1.toUpperCase().equals(str2.toUpperCase())) return 65536;
            else return 1;
        }
        
        answer = 65536 * inner / sum;
        
        return answer;
    }
}