import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] array = new int[n][m];
        for(int i=0; i<n; i++){
            String input = br.readLine();
            for(int j=0; j<m; j++){
                array[i][j] = input.charAt(j) - '0';
            }
        }

        int min = Math.min(n, m);
        int max_sum = 0;
        int answer = 0;

        if (min == 1){
            System.out.println(1);
            return;
        }

        for(int size=2; size<=n; size ++){
            int find = check(size, array);
            if (max_sum < find) {
                max_sum = find;
                answer = size * size;
            }
            if (find == -1) answer = Math.max(answer, 1);
        }
        System.out.println(answer);
        br.close();
    }

    private static int check(int size, int[][] array) {
        int result = 0;

        for(int i=0; i<=array.length-size; i++){
            for(int j=0; j<=array[0].length-size; j++){
                int a = array[i][j];
                int b = array[i][j+size-1];
                int c = array[i+size-1][j];
                int d = array[i+size-1][j+size-1];

                if (a == b && b == c && c == d){
                    return size;
                }
            }
        }
        return -1;
    }
}
