import java.util.*;

public class Solution {

    static int n, k;
    static ArrayList<Bag> arrayList;
    static int[][] dp;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            n = sc.nextInt();
            k = sc.nextInt();
            arrayList = new ArrayList<>();
            dp = new int[n+1][k+1];

            for(int i=0; i<n; i++) {
                arrayList.add(new Bag(sc.nextInt(), sc.nextInt()));
            }

            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= k; j++) {
                    dp[i][j] = -1;
                }
            }

            System.out.println("#" + tc + " " + recursion(0, 0));
        }
    }

    private static int recursion(int idx, int weight) {

        if (idx == n) return 0;

        if (weight > k) return Integer.MIN_VALUE;

        if (dp[idx][weight] != -1) return dp[idx][weight];

        if (weight + arrayList.get(idx).w <= k) {
            dp[idx][weight] = Math.max(recursion(idx + 1, weight + arrayList.get(idx).w)+arrayList.get(idx).v, recursion(idx+1, weight));
        }
        else{
            dp[idx][weight] = recursion(idx+1, weight);
        }

        return dp[idx][weight];
    }

    private static class Bag {
        int w;
        int v;

        public Bag(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
}
