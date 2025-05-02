import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static int[][] graph;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            br.readLine();

            int x = 0;
            int y = 0;
            char[][] temp = new char[16][16];
            graph = new int[16][16];
            for (int i = 0; i < 16; i++) {
                temp[i] = br.readLine().toCharArray();
                for (int j = 0; j < 16; j++) {
                    graph[i][j] = temp[i][j] - '0';
                    if (graph[i][j] == 2) {
                        x = i;
                        y = j;
                    }
                }
            }

            if (bfs(x, y))
                System.out.println("#" + tc + " " + 1);
            else System.out.println("#" + tc + " " + 0);

        }
        br.close();
    }

    private static boolean bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        graph[x][y] = 1;

        while (!queue.isEmpty()){
            int[] poll = queue.poll();

            for(int i=0; i<4; i++){
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if (nx >= 0 && nx < 16 && ny >= 0 && ny < 16){
                    if (graph[nx][ny] == 3) return true;
                    else if (graph[nx][ny] == 0){
                        queue.add(new int[]{nx, ny});
                        graph[nx][ny] = 1;
                    }
                }
            }
        }
        return false;
    }
}
