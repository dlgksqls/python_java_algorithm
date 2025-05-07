import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static ArrayList<Integer>[] taller;
    static ArrayList<Integer>[] shorter;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());

            taller = new ArrayList[N+1];
            shorter = new ArrayList[N+1];

            for(int i = 1; i <= N; i++) {
                taller[i] = new ArrayList<>();
                shorter[i] = new ArrayList<>();
            }

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                taller[a].add(b);   // a보다 큰 학생 b
                shorter[b].add(a);  // b보다 작은 학생 a
            }

            int answer = 0;
            for(int i = 1; i <= N; i++) {
                boolean[] visited = new boolean[N+1];
                int tallCount = dfs(i, taller, visited);

                visited = new boolean[N+1];
                int shortCount = dfs(i, shorter, visited);

                if (tallCount + shortCount == N - 1) {
                    answer++;
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }

    private static int dfs(int cur, ArrayList<Integer>[] graph, boolean[] visited) {
        visited[cur] = true;
        int count = 0;

        for (int next : graph[cur]) {
            if (!visited[next]) {
                count += 1 + dfs(next, graph, visited);
            }
        }

        return count;
    }
}
