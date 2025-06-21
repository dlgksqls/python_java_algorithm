import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] array;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        array = new int[n+1];
        dp = new int[n+1];
        for(int i=1; i<=n; i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(array[1]);
            return;
        }
        else if (n == 2) {
            System.out.println(array[1] + array[2]);
            return;
        }

        initializeDp(n);
        for(int i=3; i<=n; i++){
            dp[i] = Math.max(dp[i - 3] + array[i - 1], dp[i - 2]) + array[i];
        }
//        System.out.println(dp[n]);

        initializeDp(n);
        System.out.println(recursion(n));
        br.close();
    }

    private static int recursion(int n) {
        if (dp[n] != -1) return dp[n];
        if (n == 1) return dp[1];
        if (n == 2) return dp[2];

        if (n > 0) {
            dp[n] = Math.max(recursion(n - 3) + array[n - 1], recursion(n - 2)) + array[n];
            return dp[n];
        }
        return 0;
    }

    private static void initializeDp(int n){
        dp = new int[n+1];
        for(int i=0; i<=n; i++){
            dp[i] = -1;
        }
        
        dp[1] = array[1];
        dp[2] = array[1] + array[2];
    }
}
