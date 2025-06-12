class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int walletRow = wallet[0];
        int walletCol = wallet[1];
        
        int billRow = bill[0];
        int billCol = bill[1];
        
        while(true){
            if (walletRow < billRow || walletCol < billCol){
                if (billRow >= billCol){
                    if (billRow % 2 >= 5) billRow /= 2 - 1;
                    else billRow /= 2;
                }
                else {
                    if (billCol % 2 >= 5) billCol /= 2 - 1;
                    else billCol /= 2;
                }
                answer ++;
            }
        
            
            if ((walletRow >= billRow && walletCol >= billCol)
                || (walletRow >= billCol && walletCol >= billRow))
                break;
        }
        return answer;
    }
}