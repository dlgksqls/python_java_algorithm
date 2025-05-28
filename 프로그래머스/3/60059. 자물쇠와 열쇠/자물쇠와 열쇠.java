class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int[][] newLock = new int[lock.length * 3][lock.length * 3];
        int n = lock.length;
        int m = key.length;
        
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j++){
                newLock[i + n][j + n] = lock[i][j];
            }
        }
        
        for(int rotate = 0; rotate < 4; rotate++){
            key = rotate(key);
            for(int i = 0; i < n * 2; i++){
                for(int j = 0; j < n * 2; j++){
                    for(int k = 0; k < m; k ++){
                        for(int l = 0; l < m; l++){
                            newLock[i + k][j + l] += key[k][l];
                        }
                    }
                    if (check(newLock, n)) return true;
                    for(int k = 0; k < m; k++){
                        for(int l = 0; l < m; l++){
                            newLock[i + k][j + l] -= key[k][l];
                        }
                    }
                }
            }
        }
        return false;
    }
    
    boolean check(int[][] newLock, int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if (newLock[i + n][j + n] != 1) return false;
            }
        }
        return true;
    }
    
    int[][] rotate(int[][] key){
        int[][] temp = new int[key.length][key[0].length];
        for(int i=0; i<key.length; i++){
            for(int j=0; j<key.length; j++){
                temp[j][key.length-1-i] = key[i][j];
            }
        }
        
        return temp;
    }
}