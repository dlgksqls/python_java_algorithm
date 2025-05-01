import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static int n;
    static int[][] graph;
    static int[][] dist;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc ++) {
            n = Integer.parseInt(br.readLine());
            graph = new int[n + 1][n + 1];
            dist = new int[n+1][n+1];
            char[][] char_array = new char[n+1][n+1];

            for(int i=1; i<=n; i++){
                char_array[i] = br.readLine().toCharArray();
                for(int j=1; j<=n; j++){
                    graph[i][j] = char_array[i][j-1] - '0';
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            dist[1][1] = 0;
            bfs(1, 1);

            System.out.println("#" + tc + " " + dist[n][n]);
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int node_x = poll[0];
            int node_y = poll[1];

            for(int i=0; i<4; i++){
                int nx = node_x + dx[i];
                int ny = node_y + dy[i];

                if (nx >= 0 && nx <= n && ny >= 0 && ny <= n){
                    if (dist[nx][ny] > graph[nx][ny] + dist[node_x][node_y]){
                        dist[nx][ny] = graph[nx][ny] + dist[node_x][node_y];
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
