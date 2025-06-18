import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] array = new int[n][m];
            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                array[y][x] = 1;
            }

            Queue<int[]> queue = new LinkedList<>();
            int answer = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if (array[i][j] == 1) {
                        answer ++;
                        queue.add(new int[]{i, j});
                        while (!queue.isEmpty()) {
                            int[] poll = queue.poll();
                            for(int move=0; move<4; move++){
                                int nx = poll[0] + dx[move];
                                int ny = poll[1] + dy[move];

                                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                                    if (array[nx][ny] == 1){
                                        array[nx][ny] = 0;
                                        queue.add(new int[]{nx, ny});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
