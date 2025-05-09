import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static boolean[] visited;
    static long answer;
    static Worm[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());
            array = new Worm[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                array[i] = new Worm(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            answer = Long.MAX_VALUE;
            visited = new boolean[n];
            
            recursion(0, 0, n);

            System.out.println("#" + tc + " " + answer);
        }
        br.close();
    }

    private static void recursion(int start, int count, int n) {
        if (count == n / 2) {
            cal(n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            recursion(i + 1, count + 1, n);
            visited[i] = false;
        }
    }

    private static void cal(int n) {
        long x = 0;
        long y = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                x += array[i].x;
                y += array[i].y;
            } else {
                x -= array[i].x;
                y -= array[i].y;
            }
        }

        long result = x * x + y * y;
        answer = Math.min(answer, result);
    }

    private static class Worm {
        int x, y;

        public Worm(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
