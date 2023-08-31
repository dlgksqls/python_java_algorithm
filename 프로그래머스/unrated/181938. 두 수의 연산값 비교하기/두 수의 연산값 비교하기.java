class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        String sum_1 = String.valueOf(a);
        String sum_2 = String.valueOf(b);
        String sum_result = sum_1 + sum_2;
        
        if (Integer.valueOf(sum_result) > 2 * a * b)
            return Integer.valueOf(sum_result);
        else if (Integer.valueOf(sum_result) < 2 * a * b)
            return 2 * a * b;
        else
            return Integer.valueOf(sum_result);
    }
}