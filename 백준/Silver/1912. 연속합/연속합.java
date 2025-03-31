import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] array;
    static int[] sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new int[n+1];
        sum = new int[n+1];

        int max = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            array[i] = Integer.parseInt(st.nextToken());
            sum[i] = Math.max(sum[i-1] + array[i], array[i]);
            if (max < sum[i]) max = sum[i];
        }

        System.out.println(max);
        br.close();
    }
}
