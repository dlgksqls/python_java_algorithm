import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int answer;
    static int n;
    static int[] array;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            n = Integer.parseInt(br.readLine());
            array = new int[n];
            visited = new boolean[n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }

            answer = 0;
            recursion(0, 0, 0);

            System.out.println("#" + tc + " " + answer);
        }
        br.close();
    }

    private static void recursion(int idx, int left, int right) {
        if (idx == n) {
            if (left >= right) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;

                // 현재 추를 왼쪽에 놓는 경우
                recursion(idx + 1, left + array[i], right);

                // 현재 추를 오른쪽에 놓는 경우 (왼쪽 무게가 오른쪽보다 커야 함)
                if (left >= right + array[i]) {
                    recursion(idx + 1, left, right + array[i]);
                }

                visited[i] = false;
            }
        }
    }
}