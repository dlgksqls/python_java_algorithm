import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    static int n, l;
    static ArrayList<Ingre> array;
    static int[][] dp;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            n = sc.nextInt();
            l = sc.nextInt();

            array = new ArrayList<>();
            dp = new int[n + 1][l + 1];

            for(int i = 0; i < n; i++) {
                array.add(new Ingre(sc.nextInt(), sc.nextInt()));
            }

            for(int i = 1; i <= n; i++) {
                for(int j = 0; j <= l; j++) {
                    Ingre cur = array.get(i - 1);
                    if (cur.kal > j) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cur.kal] + cur.score);
                    }
                }
            }

            System.out.println("#" + tc + " " + dp[n][l]);
        }
    }

    private static class Ingre {
        int score, kal;

        public Ingre(int score, int kal) {
            this.score = score;
            this.kal = kal;
        }
    }
}
