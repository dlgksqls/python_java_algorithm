import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int answer;
    static int n;
    static int[] array;
    static int[] per;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            n = Integer.parseInt(br.readLine());
            array = new int[n];
            visited = new boolean[n];
            per = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }

            answer = 0;

            combination(0);

            System.out.println("#" + tc + " " + answer);
        }
        br.close();
    }

    private static void combination(int depth) {
        if (depth == n){
            recursion(0, 0, 0);
            return;
        }

        for(int i=0; i<n; i++){
            if (!visited[i]){
                visited[i] = true;
                per[depth] = array[i];
                combination(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void recursion(int idx, int left, int right) {
        if (left < right) {
            return;
        }

        if (idx == n){
            answer ++;
            return;
        }

        recursion(idx + 1, left + per[idx], right);

        recursion(idx + 1, left, right + per[idx]);
    }
}