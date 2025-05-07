import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc ++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            graph = new ArrayList[n+1];
            for(int i=1; i<=n; i++){
                graph[i] = new ArrayList<>();
            }

            for(int i=1; i<=m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a].add(b);
                graph[b].add(a);
            }

            int answer = 0;

            visited = new boolean[n+1];
            for(int i=1; i<= n; i++){
                if (!visited[i]) {
                    answer++;
                    dfs(i);
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
        br.close();
    }

    private static void dfs(int idx) {
        visited[idx] = true;

        for (Integer i : graph[idx]) {
            if (!visited[i]){
                dfs(i);
            }
        }
    }
}
