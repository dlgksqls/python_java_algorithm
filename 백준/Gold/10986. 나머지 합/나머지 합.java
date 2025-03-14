import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static long answer;
    static long[] sum;
    static long[] module;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = 0;

        sum = new long[n + 1];
        module = new long[m]; // 나머지를 가지고 있는 배열

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
            // 나머지를 양수로 변환
            int mod = (int) ((sum[i] % m + m) % m);
            if (mod == 0) {
                answer++;
            }
            module[mod]++;
        }

        for (int i = 0; i < m; i++) {
            if (module[i] > 1) {
                answer += (module[i] * (module[i] - 1)) / 2;
            }
        }

        System.out.println(answer);
        br.close();
    }
}
