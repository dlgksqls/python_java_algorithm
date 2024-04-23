import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[] arr;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(max);
    }

    public static void dfs(int number) {
        // 만약 현재 만든 수가 N보다 크다면 리턴
        if (number > N) return;
        // 현재 만든 수가 N 이하이면 최대값 갱신
        if (number > max) {
            max = number;
        }
        // 주어진 숫자들로 가능한 모든 수 시도
        for (int i = 0; i < K; i++) {
            dfs(number * 10 + arr[i]);
        }
    }
}
