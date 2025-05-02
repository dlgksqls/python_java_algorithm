import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static int answer;
    static char[][] graph;
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            n = Integer.parseInt(br.readLine());
            answer = 0;

            graph = new char[n][n];
            for (int i = 0; i < n; i++) {
                graph[i] = br.readLine().toCharArray();
            }

            for(int i=0; i<n; i++){
                for (int j=0; j<n; j++){
                    if (graph[i][j] == '.'){
                        if (is_safe(i, j)) {
                            answer ++;
                            bfs(i, j);
                        }
                    }
                }
            }

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if (graph[i][j] == '.'){
                        answer ++;
                    }
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        graph[x][y] = 'o';

        while(!queue.isEmpty()){
            int[] poll = queue.poll();

            if (!is_safe(poll[0], poll[1])) continue;

            for(int i=0; i<8; i++){
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (graph[nx][ny] == '.') {
                        graph[nx][ny] = 'o';
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    private static boolean is_safe(int x, int y) {
        for(int i=0; i<8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && graph[nx][ny] == '*')
                return false;
        }
        return true;
    }
}