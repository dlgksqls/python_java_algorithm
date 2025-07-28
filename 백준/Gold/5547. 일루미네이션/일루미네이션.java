import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int w, h;
    static int[][] array;
    static boolean[][] visited;
//    static int[][] evenDir = {{-1, -1}, {0, -1}, {1, 0}, {0, 1}, {-1, 1}, {-1, 0}};
//    static int[][] oddDir = {{0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 0}};
    static int[][] evenDir = {{-1, -1}, {-1, 0}, {0, 1}, {1, 0}, {1, -1}, {0, -1}};
    static int[][] oddDir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {0, -1}};
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        array = new int[h+2][w+2];
        visited = new boolean[h+2][w+2];

        for(int i=1; i<=h; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=w; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
                if (array[i][j] == 1) visited[i][j] = true;
            }
        }

        bfs(0, 0);

        System.out.println(answer);
        br.close();
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nowX = poll[0];
            int nowY = poll[1];

            int nx;
            int ny;

            for (int i = 0; i < 6; i++) {
                if (nowX % 2 == 0){
                    nx = nowX + evenDir[i][0];
                    ny = nowY + evenDir[i][1];
                }
                else{
                    nx = nowX + oddDir[i][0];
                    ny = nowY + oddDir[i][1];
                }

                if (nx < 0 || nx >= h+2 || ny < 0 || ny >= w+2) continue;
                if (array[nx][ny] == 1){
                    answer ++;
                    continue;
                }

                if (visited[nx][ny]) continue;
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }
    }
}
