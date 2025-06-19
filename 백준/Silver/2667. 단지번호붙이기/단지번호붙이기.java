import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] array;
    static ArrayList<Integer> houses;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int answer = 0;

        n = Integer.parseInt(br.readLine());
        array = new int[n][n];

        for(int i=0; i<n; i++){
            String col = br.readLine();
            for(int j=0; j<n; j++){
                array[i][j] = col.charAt(j) - '0';
            }
        }

        houses = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if (array[i][j] != 0){
                    answer ++;
                    bfs(i, j);
                }
            }
        }

        Collections.sort(houses);
        System.out.println(answer);
        for (Integer house : houses) {
            System.out.println(house);
        }

        br.close();
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        array[x][y] = 0;
        int count = 1;

        while(!queue.isEmpty()){
            int[] poll = queue.poll();

            for(int i=0; i<4; i++){
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n){
                    if (array[nx][ny] == 1){
                        queue.add(new int[]{nx, ny});
                        array[nx][ny] = 0;
                        count ++;
                    }
                }
            }
        }
        houses.add(count);
    }
}
