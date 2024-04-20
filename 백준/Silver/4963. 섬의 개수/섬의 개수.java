import java.io.*;
import java.util.*;
public class Main {
    static int graph[][];
    static int w, h;
    static Queue<int []> queue;
    static int dx[] = {-1, 1, 0, 0, -1, 1, 1, -1};
    static int dy[] = {0, 0, 1, -1, 1, 1, -1, -1};
    public static void bfs(int x, int y){
        queue = new LinkedList<>();

        queue.offer(new int [] {x, y});
        graph[x][y] = 0;

        while (!queue.isEmpty()){
            int poll[] = queue.poll();

            for (int i=0; i<8; i++){
                int nx = dx[i] + poll[0];
                int ny = dy[i] + poll[1];

                if (nx>=0 && nx<h && ny>=0 && ny<w){
                    if (graph[nx][ny] == 1){
                        queue.offer(new int [] {nx, ny});
                        graph[nx][ny] = 0;
                    }
                }
            }
        }

    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true){
            int answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0)
                break;

            graph = new int[h][w];

            for (int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<w; j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i=0; i<h; i++){
                for (int j=0; j<w; j++){
                    if (graph[i][j] == 1) {
                        answer++;
                        bfs(i, j);
                    }
                }
            }
            System.out.println(answer);
        }
        br.close();
        bw.close();
    }
}
