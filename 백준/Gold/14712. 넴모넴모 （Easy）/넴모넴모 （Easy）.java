import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static boolean[][] array;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new boolean[n][m];
        recursion(0, 0);

        System.out.println(answer);
        br.close();
    }

    private static void recursion(int x, int y) {
        if (x == n){
            answer ++;
            return;
        }

        int nextX = x;
        int nextY = y+1;

        if (nextY == m){
            nextX += 1;
            nextY = 0;
        }

        recursion(nextX, nextY);

        array[x][y] = true;
        if (!check(x, y)){
            recursion(nextX, nextY);
        }
        array[x][y] = false;
    }

    private static boolean check(int x, int y) {
        if (x >= 1 && y >= 1){
            return array[x-1][y-1] && array[x-1][y] && array[x][y-1];
        }
        return false;
    }
}
