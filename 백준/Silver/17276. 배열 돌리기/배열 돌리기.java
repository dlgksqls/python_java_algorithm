import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) / 45;

            array = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    array[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<Math.abs(d); i++) {
                array = rotate(d);
            }

            for (int[] row : array) {
                for (int val : row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }
        }
        br.close();
    }

    private static int[][] rotate(int d) {
        int[][] tmp = new int[n][n];
        int center = n / 2;

        for(int i=0; i<n; i++){
            if (d > 0){
                tmp[i][center] = array[i][i];
                tmp[i][n-i-1] = array[i][center];
                tmp[center][n-i-1] = array[i][n-i-1];
                tmp[i][i] = array[center][i];
            }
            else{
                tmp[center][i] = array[i][i];
                tmp[i][i] = array[i][center];
                tmp[i][center] = array[i][n-i-1];
                tmp[i][n-i-1] = array[center][n-i-1];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tmp[i][j] == 0) tmp[i][j] = array[i][j];
            }
        }

        return tmp;
    }
}
