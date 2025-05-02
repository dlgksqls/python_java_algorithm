import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            int[][] graph = new int[100][100];
            int T = Integer.parseInt(br.readLine());

            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int x = 99;
            int y = 0;
            for (int j = 99; j >= 0; j--) {
                if (graph[99][j] == 2) {
                    y = j;
                    break;
                }
            }

            while(x > 0){
                if (y > 0 && graph[x][y-1] == 1) {
                    while (y > 0 && graph[x][y-1] == 1) y--;
                }
                else if (y < 99 && graph[x][y+1] == 1) {
                    while (y < 99 && graph[x][y+1] == 1) y ++;
                }
                x --;
            }

            System.out.println("#" + tc + " " + y);
        }
        br.close();
    }
}
