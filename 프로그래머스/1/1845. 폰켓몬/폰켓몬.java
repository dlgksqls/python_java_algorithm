import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int num_size = nums.length / 2;
        HashSet<Integer> hashSet = new HashSet<>();
        
        for (int i=0; i<nums.length; i++){
            hashSet.add(nums[i]);
        }
    
        if (num_size < hashSet.size()) return num_size;
        return hashSet.size();
    }
}