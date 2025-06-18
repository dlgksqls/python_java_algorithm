import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] dp = new boolean[n+1][m+1];

        st = new StringTokenizer(br.readLine());
        int[] list = new int[n+1];
        for(int i=1; i<=n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][s] = true;

        for(int i=1; i<=n; i++){
            for(int j=0; j<=m; j++){
                if (dp[i-1][j]){
                    if ((j) + list[i] <= m) dp[i][j+list[i]] = true;
                    if ((j) - list[i] >= 0) dp[i][j-list[i]] = true;
                }
            }
        }

        int result = -1;
        for(int vol = m; vol >= 0; vol --){
            if (dp[n][vol]) {
                result = vol;
                break;
            }
        }

        System.out.println(result);
        br.close();
    }
}
