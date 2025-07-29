import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int h, w, sr, sc, fr, rc;
    static int[][] array;
    static boolean[][] visited;
    static int answer = 0;
    static boolean isArrive = false;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
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

        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        sr = Integer.parseInt(st.nextToken()) - 1;
        sc = Integer.parseInt(st.nextToken()) - 1;
        fr = Integer.parseInt(st.nextToken()) - 1;
        rc = Integer.parseInt(st.nextToken()) - 1;

        System.out.println(bfs());

        br.close();
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc, 0});
        visited[sr][sc] = true;

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int nowX = poll[0];
            int nowY = poll[1];
            int dist = poll[2];

            if (nowX == fr && nowY == rc){
                return dist;
            }

            for(int i=0; i<4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx < 0 || nx + h > n || ny < 0 || ny + w > m) continue;
                if (visited[nx][ny]) continue;
                if (!check(nx, ny)) continue;

                visited[nx][ny] = true;
                answer ++;
                queue.add(new int[]{nx, ny, dist + 1});
            }
        }
        return -1;
    }

    private static boolean check(int nx, int ny) {
        for(int i=nx; i<nx+h; i++){
            for(int j=ny; j<ny+w; j++){
                if (array[i][j] == 1) return false;
            }
        }
        return true;
    }
}