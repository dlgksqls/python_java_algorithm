class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        int count = 0;
        
        for (boolean i : included){
            if (i)
                answer += a + (d  * count);
            count++;
        }
        return answer;
    }
}