import java.util.*;

public class Solution {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int[] array = new int[n];
            int[] dp = new int[n];
            for(int i=0; i<n; i++){
                array[i] = sc.nextInt();
                dp[i] = 1;
            }

            int answer = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<i; j++){
                    if (array[i] > array[j]){
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            for(int i=0; i<n; i++){
                answer = Math.max(answer, dp[i]);
            }
            System.out.println("#" + tc + " " + answer);
        }
    }
}
