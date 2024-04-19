import java.util.*;
import java.io.*;
public class Main {
    static int graph[][];
    static int m, n;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static Queue<int []> queue;
    static boolean answer;

    public static void bfs(int x, int y){
        queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        graph[x][y] = 1;

        while (!queue.isEmpty()){
            int poll[] = queue.poll();

            for (int i=0; i<4; i++){
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if (nx>=0 && nx<m && ny>=0 && ny<n){
                    if (graph[nx][ny] == 0){
                        if (nx == m-1){
                            answer = true;
                            return;
                        }
                        queue.offer(new int[] {nx, ny});
                        graph[nx][ny] = 1;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        graph = new int[m][n];

        for (int i=0; i<m; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i=0; i<n; i++){
            if (graph[0][i] == 0)
                bfs(0, i);
        }

        if (answer)
            System.out.println("YES");
        else
            System.out.println("NO");

        br.close();
    }
}
