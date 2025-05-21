import java.util.*;

public class Solution {

    static boolean flag;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            char[][] array = new char[n][n];

            for(int i=0; i<n; i++){
                array[i] = sc.next().toCharArray();
            }

            int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
            int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

            flag = false;
            outer:
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if (array[i][j] == 'o') {
                        check(i, j, dx, dy, array, n);
                        if (flag) break outer;
                    }
                }
            }
            System.out.println("#" + tc + " " + ((flag) ? "YES" : "NO"));
        }
    }

    private static void check(int x, int y, int[] dx, int[] dy, char[][] array, int n) {
        for(int i=0; i<8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            int count = 1;
            while (nx >= 0 && nx < n && ny >= 0 && ny < n){
                if (array[nx][ny] == 'o'){
                    count ++;
                    nx += dx[i];
                    ny += dy[i];
                }
                else {
                    flag = false;
                    break;
                }
                if (count == 5){
                    flag = true;
                    return;
                }
            }
        }
    }
}
