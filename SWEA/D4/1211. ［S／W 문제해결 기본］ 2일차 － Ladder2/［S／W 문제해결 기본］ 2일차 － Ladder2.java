import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int tc = 1; tc <= 10; tc ++){
            int n = Integer.parseInt(br.readLine());
            int[][] array = new int[100][100];

            for(int i=0; i<100; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++){
                    array[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int min = Integer.MAX_VALUE;
            int answer = 0;
            for(int i=0; i<100; i++){
                if (array[0][i] == 1){
                    if (min >= search(0, i, 0, array)) {
                        min = search(0, i, 0, array);
                        answer = i;
                    }
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }

    private static int search(int y, int x, int count, int[][] array) {
        boolean[][] visited = new boolean[100][100];

        while(y < 99){
            visited[y][x] = true;
            count ++;

            // 왼쪽
            if (x > 0 && array[y][x-1] == 1 && !visited[y][x-1]){
                while (x > 0 && array[y][x-1] == 1 && !visited[y][x-1]) {
                    x--;
                    visited[y][x] = true;
                    count++;
                }
            }

            // 오른쪽
            if (x < 99 && array[y][x+1] == 1 && !visited[y][x+1]){
                while (x < 99 && array[y][x+1] == 1 && !visited[y][x+1]) {
                    x++;
                    visited[y][x] = true;
                    count++;
                }
            }

            y ++;
        }

        return count;
    }
}
