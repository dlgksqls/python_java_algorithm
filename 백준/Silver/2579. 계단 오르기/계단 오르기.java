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
            dp[i] = -1;
        }

        dp[0] = 0;
        if (n == 1) {
            System.out.println(array[1]);
            return;
        }
        else if (n == 2){
            System.out.println(array[1] + array[2]);
            return;
        }
        dp[1] = array[1];
        dp[2] = array[1] + array[2];

        System.out.println(recursion(n));
        br.close();
    }

    private static int recursion(int i) {
        if (dp[i] != -1) return dp[i];
        if (i == 1) return dp[1];
        else if (i == 2) return dp[2];

        dp[i] = Math.max(recursion(i-3) + array[i-1], recursion(i-2)) + array[i];
        return dp[i];
    }
}
