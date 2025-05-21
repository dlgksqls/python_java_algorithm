import java.util.*;

public class Solution {

    static int n;
    static int[][] array;
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            n = sc.nextInt();
            int m = sc.nextInt();

            array = new int[n+1][n+1];
            array[n/2][n/2] = 2;
            array[n/2+1][n/2+1] = 2;
            array[n/2][n/2+1] = 1;
            array[n/2+1][n/2] = 1;

            for(int i=0; i<m; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                int color = sc.nextInt();

                check(x, y, color);
            }

            int black = 0;
            int white = 0;
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if (array[i][j] == 1) black ++;
                    else if (array[i][j] == 2) white ++;
                }
            }

            System.out.println("#" + tc + " " + black + " " + white);
        }
    }

    private static void check(int x, int y, int color) {
        array[x][y] = color;
        int op = (color == 1) ? 2 : 1;

        for(int i=0; i<8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            ArrayList<int[]> change_idx = new ArrayList<>();
            while(nx >= 1 && nx <= n && ny >= 1 && ny <= n && array[nx][ny] == op){
                change_idx.add(new int[]{nx, ny});
                nx += dx[i];
                ny += dy[i];
            }

            if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && array[nx][ny] == color){
                for (int[] changeIdx : change_idx) {
                    array[changeIdx[0]][changeIdx[1]] = color;
                }
            }
        }
    }
}