import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int time = 0;

        int[][] array = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            visited = new boolean[n][n];
            boolean isMove = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        List<int[]> moves = bfs(i, j, l, r, array);
                        if (moves.size() > 1) {
                            move(moves, array);
                            isMove = true;
                        }
                    }
                }
            }
            if (!isMove) break;
            time ++;
        }

        System.out.println(time);
        br.close();
    }

    private static ArrayList<int[]> bfs(int x, int y, int l, int r, int[][] array) {
        Queue<int[]> queue = new LinkedList<>();
        ArrayList<int[]> union = new ArrayList<>();

        queue.add(new int[]{x, y});
        union.add(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] poll = queue.poll();

            for(int i=0; i<4; i++){
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if (nx >= 0 && nx < array.length && ny >= 0 && ny < array.length && !visited[nx][ny]){
                    int diff = Math.abs(array[poll[0]][poll[1]] - array[nx][ny]);
                    if(l <= diff && diff <= r){
                        queue.add(new int[]{nx, ny});
                        union.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return union;
    }

    private static void move(List<int[]> moves, int[][] array) {
        int result = 0;
        for (int[] move : moves) {
            result += array[move[0]][move[1]];
        }

        result /= moves.size();
        for (int[] move : moves) {
            array[move[0]][move[1]] = result;
        }
    }
}
