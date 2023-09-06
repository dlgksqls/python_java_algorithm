class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        String odd = "";
        String even = "";
        
        for(int i:num_list){
            if (i % 2 == 0)
                even += Character.forDigit(i , 10);
            else
                odd += Character.forDigit(i , 10);
        }
        answer += Integer.parseInt(even) + Integer.parseInt(odd);
    
            
        return answer;
    }
}