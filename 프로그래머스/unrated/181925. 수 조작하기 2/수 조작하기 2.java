class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        
        for (int i=0; i<numLog.length-1; i++){
            
            int first = numLog[i];
            int second = numLog[i+1];
            
            if (second - first == 1)
                answer += "w";
            else if (second - first == -1)
                answer += "s";
            else if (second -first == 10)
                answer += "d";
            else if (second - first == -10)
                answer += "a";
            
        }
        
        return answer;
    }
}