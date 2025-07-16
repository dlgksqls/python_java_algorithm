import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static boolean[][] chess;
    static boolean[] col;
    static boolean[] cross_1;
    static boolean[] cross_2;

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        col = new boolean[n];
        cross_1 = new boolean[2 * n - 1];
        cross_2 = new boolean[2 * n - 1];

        recursion(0);

        System.out.println(answer);
        br.close();
    }

    private static void recursion(int depth) {
        if (depth == n) {
            answer ++;
            return;
        }

        for(int i=0; i<n; i++){
            if (col[i] || cross_1[depth + i] || cross_2[depth - i + n - 1]) continue;
            col[i] = true;
            cross_1[depth + i] = true;
            cross_2[depth - i + n - 1] = true;

            recursion(depth + 1);

            col[i] = false;
            cross_1[depth + i] = false;
            cross_2[depth - i + n - 1] = false;
        }
    }

    private static boolean check() {
        int[] dx = {1, 1};     // ↙, ↘
        int[] dy = {1, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (chess[i][j]) {
                    // 행, 열 검사
                    for (int k = 0; k < n; k++) {
                        if (k != j && chess[i][k]) return false;
                        if (k != i && chess[k][j]) return false;
                    }

                    // 대각선 검사
                    for (int dir = 0; dir < 2; dir++) {
                        int nx = i + dx[dir];
                        int ny = j + dy[dir];

                        while (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                            if (chess[nx][ny]) return false;
                            nx += dx[dir];
                            ny += dy[dir];
                        }
                    }
                }
            }
        }
        return true;
    }
}
