import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        String arr[] = s.split("\\},\\{");
        
        for(int i=0; i<arr.length-1; i++){
            int min_length = arr[i].length();
            for(int j=i+1; j<arr.length; j++){
                if (arr[j].length() < min_length){
                    min_length = arr[j].length();
                    String tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        for(String nums : arr){
            String[] strs = nums.split(",");
            for(String str : strs){
                int val = Integer.parseInt(str);
                if (set.contains(val)) continue;
                set.add(val);
                list.add(val);
            }
        }
        return list.stream().mapToInt(x -> x).toArray();
    }
}