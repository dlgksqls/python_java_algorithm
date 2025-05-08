import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int[][] array;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean isPossible;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc = 1; tc <= 10; tc ++){
            int n = Integer.parseInt(br.readLine());
            int start_x = 0;
            int start_y = 0;
            array = new int[100][100];

            for(int i=0; i<100; i++){
                String input = br.readLine();
                for(int j=0; j<100; j++){
                    array[i][j] = input.charAt(j) - '0';
                    if (array[i][j] == 2) {
                        start_y = i;
                        start_x = j;
                    }
                }
            }

            isPossible = false;
            dfs(start_x, start_y);

            System.out.println("#" + tc + " " + (isPossible ? 1 : 0));
        }

        br.close();
    }

    private static void dfs(int x, int y) {
        array[y][x] = 1;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < 100 && ny >= 0 && ny < 100){
                if (array[ny][nx] == 3){
                    isPossible = true;
                    return;
                }
                else if(array[ny][nx] == 0){
                    dfs(nx, ny);
                }
            }
        }
    }
}
