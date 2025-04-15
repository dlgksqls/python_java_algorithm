import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] array;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        array = new int[n];
        dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for(int i=0; i<n; i++){
            for (int j=0; j<i; j++){
                if (array[i] > array[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int answer = Arrays.stream(dp).max().getAsInt();
        System.out.println(answer);
    }
}
