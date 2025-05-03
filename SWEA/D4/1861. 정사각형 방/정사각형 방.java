import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int n;
    static int array[][];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc ++) {
            n = Integer.parseInt(br.readLine());

            array = new int[n][n];
            visited = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    array[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            int start = -1;

            for (int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    int count = dfs(i, j);
                    if (count > max) {
                        max = count;
                        start = array[i][j];
                    } else if (count == max && array[i][j] < start) {
                        start = array[i][j];
                    }
                }
            }

            System.out.println("#" + tc + " " + start + " " + max);
        }
    }

    private static int dfs(int x, int y) {
        if (visited[x][y] != 0)
            return visited[x][y];

        visited[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (array[nx][ny] == array[x][y] + 1) {
                    visited[x][y] = Math.max(visited[x][y], 1 + dfs(nx, ny));
                }
            }
        }

        return visited[x][y];
    }
}
