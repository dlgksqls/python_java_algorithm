import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Interview {
        int t;
        int p;

        public Interview(int t, int p) {
            this.t = t;
            this.p = p;
        }
    }

    static int n;
    static int[] dp;
    static ArrayList<Interview> interviews = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            interviews.add(new Interview(t, p));
            dp[i] = 0;
        }

        for(int i=n-1; i>=0; i--){
            if (i + interviews.get(i).t > n){
                dp[i] = dp[i+1];
            }
            else{
                dp[i] = Math.max(dp[i + interviews.get(i).t] + interviews.get(i).p, dp[i+1]);
            }
        }

        System.out.println(dp[0]);
        br.close();
    }
}
