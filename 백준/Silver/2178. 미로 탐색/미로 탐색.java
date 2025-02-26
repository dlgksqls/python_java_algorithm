import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] graph;
    static int[][] distance; // 각 노드까지의 거리
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n + 1][m + 1];
        distance = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i + 1][j + 1] = line.charAt(j) - '0';
            }
        }

        bfs(1, 1);

        System.out.println(distance[n][m]);

        br.close();
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        distance[x][y] = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if (nx > 0 && nx <= n && ny > 0 && ny <= m && graph[nx][ny] == 1) {
                    if (distance[nx][ny] == 0) {
                        queue.offer(new int[]{nx, ny});
                        distance[nx][ny] = distance[poll[0]][poll[1]] + 1;
                    }
                }
            }
        }
    }
}
