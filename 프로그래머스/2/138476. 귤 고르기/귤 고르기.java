import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Arrays.sort(tangerine);
        int[] array = new int[tangerine[tangerine.length-1]];
        
        for(int i=0; i<tangerine.length; i++){
            array[tangerine[i] - 1] ++;
        }
        
        Arrays.sort(array);
        
        int count = array.length - 1;
        while(k > 0){
            k = k - array[count];
            answer++;
            count--;
        }
        
        return answer;
    }
}