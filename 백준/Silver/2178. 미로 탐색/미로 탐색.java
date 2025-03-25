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
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] distance;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n+1][m+1];
        distance = new int[n+1][m+1];

        for (int i=0; i<n; i++){
            String map = br.readLine();
            for(int j=0; j<m; j++){
                graph[i+1][j+1] = map.charAt(j) - '0';
            }
        }

        bfs(1, 1);
        System.out.println(distance[n][m]);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        distance[x][y] = 1;

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for (int i=0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx > 0 && nx <= n && ny > 0 && ny <= m && graph[nx][ny] == 1){
                    if (distance[nx][ny] == 0){
                        queue.add(new int[]{nx, ny});
                        distance[nx][ny] = distance[now[0]][now[1]] + 1;
                    }
                }
            }
        }
    }
}
