import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[] scores = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            int maxSum = 0;
            for (int i = 0; i < n; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
                maxSum += scores[i];
            }

            boolean[] dp = new boolean[maxSum + 1];
            dp[0] = true;  // 부분합 0은 항상 만들 수 있음

            for (int score : scores) {
                // 뒤에서부터 반복하는 이유: 중복 방지 (같은 점수를 두 번 쓰는 것 방지)
                for (int i = maxSum; i >= 0; i--) {
                    if (dp[i]) {
                        dp[i + score] = true;
                    }
                }
            }

            int count = 0;
            for (boolean possible : dp) {
                if (possible) count++;
            }

            System.out.println("#" + tc + " " + count);
        }
    }
}
