import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static ArrayList<Integer>[] graph;
    static int[] dist;
    static int n;
    static int m;
    static int answer;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc ++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            graph = new ArrayList[n+1];
            for(int i=1; i<=n; i++){
                graph[i] = new ArrayList<>();
            }

            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }

            answer = Integer.MIN_VALUE;
            for(int i=1; i<=n; i++){
                dist = new int[n + 1];
                dist[i] = 1;
                dfs(i);
            }

            System.out.println("#" + tc + " " + answer);
        }
    }

    private static void dfs(int v) {
        answer = Math.max(answer, dist[v]);

        for(int now : graph[v]){
            if (dist[now] == 0){
                dist[now] += dist[v] + 1;
                dfs(now);
                dist[now] = 0;
            }
        }
    }
}