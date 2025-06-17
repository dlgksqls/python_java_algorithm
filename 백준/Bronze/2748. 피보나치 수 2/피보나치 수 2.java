import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] dp; // int → long, 피보나치 수가 커질 수 있어서

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        System.out.println(recursion(n));
        br.close();
    }

    private static long recursion(int v) {
        if (v <= 1) return dp[v];
        if (dp[v] == 0) {
            dp[v] = recursion(v - 1) + recursion(v - 2);
        }
        return dp[v];
    }
}