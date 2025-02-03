import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 구간 합
 * 1. 합 배열 구하기 (S[i] = A[0] + A[2] + _ + A[i];
 * 2. 합 배열 공식 S[i] = S[i-1] + A[i];
 * 3. 구간 합 구하는 공식 S[j] - S[i-1] // i에서 j까지 구간 합
 */
public class Main {
    /**
     * 첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다. 둘째 줄에는 N개의 수가 주어진다. 수는 1,000보다 작거나 같은 자연수이다.
     * 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.
     * 입력
     * 5 3
     * 5 4 3 2 1
     * 1 3
     * 2 4
     * 5 5
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br
                = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st
                = new StringTokenizer(br.readLine()); // 5 3

        int n = Integer.parseInt(st.nextToken()); // 수의 갯수
        int m = Integer.parseInt(st.nextToken()); // 합을 구해야하는 횟수

        long[] sum = new long[n+1];

        st = new StringTokenizer(br.readLine()); // 5 4 3 2 1

        for (int i=1; i<=n; i++){
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken()); 
        }

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()); // 1 3, 2 4, 5 5
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            System.out.println(sum[y] - sum[x-1]);
        }
    }
}
