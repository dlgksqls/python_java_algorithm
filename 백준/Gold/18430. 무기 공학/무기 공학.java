import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] array;
    static boolean[][] visited;
    static int[][] dx = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    static int[][] dy = {{-1, 0}, {-1, 0}, {0, 1}, {0, 1}};
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(0, 0);

        System.out.println(answer);
         br.close();
    }

    private static void recursion(int idx, int sum) {
        if (idx == n * m) {
            answer = Math.max(answer, sum);
            return;
        }

        int x = idx / m; // 행 
        int y = idx % m; // 열

        if (!visited[x][y]) {
            for (int dir = 0; dir < 4; dir++) {
                int x1 = x + dx[dir][0];
                int y1 = y + dy[dir][0];
                int x2 = x + dx[dir][1];
                int y2 = y + dy[dir][1];

                if (isValid(x1, y1) && isValid(x2, y2) && !visited[x1][y1] && !visited[x2][y2]) {
                    if (!visited[x1][y1] && !visited[x2][y2]) {
                        visited[x][y] = true;
                        visited[x1][y1] = true;
                        visited[x2][y2] = true;

                        recursion(idx + 1, sum + array[x][y] * 2 + array[x1][y1] + array[x2][y2]);

                        visited[x][y] = false;
                        visited[x1][y1] = false;
                        visited[x2][y2] = false;
                    }
                }
            }
        }
        recursion(idx + 1, sum);
    }

    private static boolean isValid(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < m) return true;
        return false;
    }
}
