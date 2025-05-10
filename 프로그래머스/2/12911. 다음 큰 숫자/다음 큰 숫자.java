class Solution {
    public int solution(int n) {
        int answer = 0;
        
        
        String n_binary = Integer.toBinaryString(n);
        int n_count = 0;
        for(int i=0; i<n_binary.length(); i++){
            if (n_binary.charAt(i) == '1') n_count ++;
        }
        int large_n = n+1;
        
        while(true){
            String large_n_binary = Integer.toBinaryString(large_n);
            int large_n_count = 0;
            
            for(int i=0; i<large_n_binary.length(); i++){
                if (large_n_binary.charAt(i) == '1') large_n_count ++;
            }
            
            if (n_count == large_n_count){
                answer = large_n;
                break;
            }
            
            large_n ++;
        }
        return answer;
    }
}