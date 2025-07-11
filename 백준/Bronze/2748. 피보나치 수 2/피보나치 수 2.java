import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n];

        if (n == 1){
            System.out.println(1);
            return;
        }
        if (n == 2){
            System.out.println(1);
            return;
        }

        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[n-1]);
        br.close();
    }
}