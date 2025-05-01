import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

    static int n;
    static HashSet<Integer> answer;
    static int[] array;
    static boolean[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc ++){
            n = Integer.parseInt(br.readLine());
            array = new int[n];
            answer = new HashSet<>();

            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for(int i=0; i<n; i++){
                array[i] = Integer.parseInt(st.nextToken());
                sum += array[i];
            }

            dp = new boolean[n + 1][sum + 1];

            recursion(0, 0);

            System.out.println("#" + tc + " " + answer.size());
        }
        br.close();
    }

    private static void recursion(int idx, int sum) {
        if (dp[idx][sum]) return;  // 이미 방문한 상태
        dp[idx][sum] = true;

        if (idx == n){
            answer.add(sum);
            return;
        }

        recursion(idx + 1, sum + array[idx]);

        recursion(idx + 1, sum);
    }
}
