import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] array = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int layers = Math.min(n, m) / 2;
        while(r != 0){
            for(int layer=0; layer<layers; layer++){
                int top = layer;
                int left = layer;
                int bottom = n - layer - 1;
                int right = m - layer - 1;
                int temp = array[top][left];

                for(int i = left; i < right; i++){
                    array[top][i] = array[top][i+1];
                }
                for(int i = top; i < bottom; i++){
                    array[i][right] = array[i+1][right];
                }
                for(int i = right; i > left; i--){
                    array[bottom][i] = array[bottom][i-1];
                }
                for(int i = bottom; i > top; i--){
                    array[i][left] = array[i-1][left];
                }

                array[top+1][left] = temp;
            }
            r --;
        }

        for (int[] row : array) {
            for (int num : row) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
