import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static char[][] graph;
    static boolean[][] visited;
    static int[][] dist;
    static int answer = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new char[n][m];
        for(int i=0; i<n; i++){
            graph[i] = br.readLine().toCharArray();
        }

        for(int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (graph[i][j] == 'L'){
                    visited = new boolean[n][m];
                    dist = new int[n][m];

                    // BFS
                    BFS(i, j);
                }
            }
        }
        System.out.println(answer);
        br.close();
    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            for(int k = 0; k<4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m){
                    if (graph[nx][ny] == 'L') {
                        if (!visited[nx][ny]) {
                            queue.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                            dist[nx][ny] = dist[x][y] + 1;
                            answer = Math.max(answer, dist[nx][ny]);
                        }
                    }
                }
            }
        }
    }
}
