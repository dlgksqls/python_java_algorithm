import java.io.*;
import java.util.*;
public class Main {
    static int graph[][];
    static int t, m, n, k;
    static Queue<int[]> queue;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static void bfs(int x, int y){
        queue = new LinkedList<>();

        queue.offer(new int[] {x, y});

        graph[x][y] = 0;

        while (!queue.isEmpty()) {
            int poll[] = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + poll[0];
                int ny = dy[i] + poll[1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (graph[nx][ny] == 1) {
                        queue.offer(new int[] {nx, ny});
                        graph[nx][ny] = 0;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(br.readLine());

        for (int i=0; i<t; i++){
            int answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            graph = new int[n][m];

            for (int j=0; j<k; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[y][x] = 1;
            }

            for (int j=0; j<n; j++){
                for (int k=0; k<m; k++){
                    if (graph[j][k] == 1){
                        answer ++;
                        bfs(j, k);
                    }
                }
            }
            System.out.println(answer);
        }
        br.close();
        bw.close();
    }
}
