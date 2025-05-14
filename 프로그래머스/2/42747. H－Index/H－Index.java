import java.util.*;

class Solution {
    public int solution(int[] array) {
        Arrays.sort(array);
        int arr_size = array.length;
        
        for(int i=0; i<arr_size; i++){
            int h = arr_size - i;
            if (array[i] >= h){
                return h;
            }
        }
        return 0;
    }
}