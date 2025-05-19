class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
     
        recursion(0, 0, numbers, target);
        return answer;
    }
    
    void recursion(int idx, int sum, int[] numbers, int target){
        if (idx == numbers.length){
            if (sum == target){
                answer ++;
            }
            return ;
        }
        
        recursion(idx + 1, sum + numbers[idx], numbers, target);
        
        recursion(idx + 1, sum - numbers[idx], numbers, target);
    }
}