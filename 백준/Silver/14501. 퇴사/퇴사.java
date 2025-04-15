import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class interview{
        int t;
        int p;

        public interview(int t, int p) {
            this.t = t;
            this.p = p;
        }
    }

    private static int recursion(int idx) {
        if (idx == n){
            return 0;
        }
        if (idx > n-1){
            return Integer.MIN_VALUE;
        }
        if (dp[idx] != -1){ // 이미 저장되어있다면
            return dp[idx];
        }

        // 상담을 하거나, 안하거나, 그 중에서 더 많은 던을 버는 경우를 내 DP 테이블에 저장한다
        dp[idx] = Math.max(recursion(idx + array.get(idx).t) + array.get(idx).p, recursion(idx+1));

        return dp[idx];
    }

    static int n;
    static List<interview> array = new ArrayList<interview>();
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n];

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            array.add(new interview(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            dp[i] = -1;
        }

        System.out.println(recursion(0));

        br.close();
    }
}
