class Solution {
    public int []solution(int[] num_list) {
        int[] answer = new int[num_list.length+1];
        int result = 0;
        
        if (num_list[num_list.length-1] > num_list[num_list.length-2])
            result = num_list[num_list.length-1] - num_list[num_list.length-2];
        else
            result = num_list[num_list.length-1] * 2;
            
        for (int i=0;i<num_list.length;i++){
                answer[i] = num_list[i];
        }
        answer[num_list.length] = result;
        return answer;
    }
}