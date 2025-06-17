import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n+1];
        int[] dp = new int[n+1];

        for(int i=1; i<=n; i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(array[1]);
            return;
        }
        if (n == 2){
            System.out.println(array[1] + array[2]);
            return;
        }
        
        dp[1] = array[1];
        dp[2] = array[1] + array[2];

        for(int i=3; i<=n; i++){
            dp[i] = Math.max(dp[i-3] + array[i-1], dp[i-2]) + array[i]; // 두칸 + 바로 전칸 vs 두칸
        }

        System.out.println(dp[n]);
        br.close();
    }
}
