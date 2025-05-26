class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int n = lock.length;
        int m = key.length;
        int[][] newLock = new int[n * 3][n * 3];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                newLock[i + n][j + n] = lock[i][j]; 
            }
        }
        
        for(int rotate=0; rotate<4; rotate++){
            key = rotate(key);
            
            for(int x=0; x<n*2; x++){
                for(int y=0; y<n*2; y++){
                    for(int i=0; i<m; i++){
                        for(int j=0; j<m; j++){
                            newLock[x+i][y+j] += key[i][j];
                        }
                    }
                    if (check(newLock, n)){
                        return true;
                    }
                    for(int i=0; i<m; i++){
                        for(int j=0; j<m; j++){
                            newLock[x+i][y+j] -= key[i][j];
                        }
                    }
                }
            }
        }
        return answer;
    }
    
    boolean check(int[][] array, int n){
    for (int i = n; i < n * 2; i++) {
        for (int j = n; j < n * 2; j++) {
            if (array[i][j] != 1) return false;
        }
    }
    return true;
}

    
    int[][] rotate(int[][] key){
        int[][] tmp = new int[key.length][key[0].length];
        for(int i=0; i<key.length; i++){
            for(int j=0; j<key[0].length; j++){
                tmp[j][key.length - 1 - i] = key[i][j]; 
            }
        }
        return tmp;
    }
}