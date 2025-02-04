import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /**
     * 수 N개 A1, A2, ..., AN이 주어진다. 이때, 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 구하는 프로그램을 작성하시오.
     * 즉, Ai + ... + Aj (i ≤ j) 의 합이 M으로 나누어 떨어지는 (i, j) 쌍의 개수를 구해야 한다.
     *
     * 입력
     * 첫째 줄에 N과 M이 주어진다. (1 ≤ N ≤ 106, 2 ≤ M ≤ 103)
     * 둘째 줄에 N개의 수 A1, A2, ..., AN이 주어진다. (0 ≤ Ai ≤ 109)
     *
     * 5 3
     * 1 2 3 1 2
     *
     * ==> 7
     *
     * 참고 https://velog.io/@isohyeon/Java-%EB%B0%B1%EC%A4%80-10986-%EB%82%98%EB%A8%B8%EC%A7%80-%ED%95%A9
     */

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long result = 0;
        long[] sum = new long[n + 1];
        long[] count = new long[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            sum[i] = (sum[i - 1] + Integer.parseInt(st.nextToken())) % m;
            if(sum[i] == 0) {
                result++;
            }
            count[(int) sum[i]]++;
        }

        for(int i=0; i<m; i++) {
            if(count[i] > 1) {
                result += (count[i]* (count[i]-1) / 2);
            }
        }
        System.out.println(result);
    }
}
