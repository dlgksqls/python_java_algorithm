import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int n, k;
    static int[][] dp;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc ++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            Bag[] array = new Bag[n];
            dp = new int[n+1][k+1];
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                array[i] = new Bag(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            for(int i=0; i<=n; i++){
                for(int j=0; j<=k; j++){
                    dp[i][j] = -1;
                }
            }

            int answer = recursion(0, 0, array);
            System.out.println("#" + tc + " " + answer);
        }
    }

    private static int recursion(int idx, int width, Bag[] array) {
        if(idx == n) return 0;
        if (width > k) return Integer.MIN_VALUE;
        if (dp[idx][width] != -1) return dp[idx][width];


        if (width + array[idx].width <= k) {
            dp[idx][width] = Math.max(recursion(idx + 1, width + array[idx].width, array) + array[idx].value,
                    recursion(idx + 1, width, array));
        }
        else{
            dp[idx][width] = recursion(idx + 1, width, array);
        }

        return dp[idx][width];
    }

    private static class Bag {
        int width;
        int value;

        public Bag(int width, int value) {
            this.width = width;
            this.value = value;
        }
    }
}
