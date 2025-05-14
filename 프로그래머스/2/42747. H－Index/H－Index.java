import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        Arrays.sort(array);
        int arr_size = array.length;
        
        for(int i=0; i<arr_size; i++){
            if(array[i] >= arr_size - i){
                answer = arr_size - i;
                break;
            }
        }
        return answer;
    }
}