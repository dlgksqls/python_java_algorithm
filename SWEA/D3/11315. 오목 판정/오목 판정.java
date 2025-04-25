import java.util.*;

public class Solution {

    static int n;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            n = sc.nextInt();
            char[][] board = new char[n][n];

            for (int i = 0; i < n; i++) {
                board[i] = sc.next().toCharArray();
            }

            boolean found = false;

            int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
            int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

            outer:
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'o') {
                        for (int d = 0; d < 8; d++) {
                            int count = 1;
                            int nx = i;
                            int ny = j;

                            for (int k = 1; k < 5; k++) {
                                nx += dx[d];
                                ny += dy[d];

                                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 'o') {
                                    count++;
                                } else {
                                    break;
                                }
                            }

                            if (count == 5) {
                                found = true;
                                break outer;
                            }
                        }
                    }
                }
            }

            System.out.println("#" + tc + " " + (found ? "YES" : "NO"));
        }
    }
}
