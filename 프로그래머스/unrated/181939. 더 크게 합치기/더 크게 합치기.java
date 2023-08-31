class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String sum_1 = String.valueOf(a) + String.valueOf(b);
        String sum_2 = String.valueOf(b) + String.valueOf(a);
        

        if (Integer.valueOf(sum_1) > Integer.valueOf(sum_2))
            return Integer.valueOf(sum_1);
        else if (Integer.valueOf(sum_1)<Integer.valueOf(sum_2))
            return Integer.valueOf(sum_2);
        else
            return Integer.valueOf(sum_1);
    }
}