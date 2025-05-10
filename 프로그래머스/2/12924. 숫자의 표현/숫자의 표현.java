class Solution {
    public int solution(int n) {
        int answer = 0;
        
        return sliding_window(n);
    }
    
public static int sliding_window(int n){
        int answer = 0;
        int start = 1;
        int end = 1;
        int sum = 1;

        while (start <= end) {
            if (sum == n) {
                answer++;
                sum -= start;
                start ++;
            } else if (sum < n) {
                end ++;
                sum += end;
            } else {
                sum -= start;
                start ++;
            }
        }
        return answer;
    }
}