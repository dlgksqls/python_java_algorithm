

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int v;
    static ArrayList<Integer>[] graph_dfs;
    static ArrayList<Integer>[] graph_bfs;
    static boolean[] visited_dfs;
    static boolean[] visited_bfs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph_dfs = new ArrayList[n+1];
        graph_bfs = new ArrayList[n+1];

        visited_dfs = new boolean[n+1];
        visited_bfs = new boolean[n+1];

        for(int i=0; i<n+1; i++){
            graph_dfs[i] = new ArrayList<Integer>();
            graph_bfs[i] = new ArrayList<Integer>();
        }

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph_dfs[a].add(b);
            graph_dfs[b].add(a);

            graph_bfs[a].add(b);
            graph_bfs[b].add(a);
        }

        for (int i=1; i<=n; i++){
            Collections.sort(graph_dfs[i]);
            Collections.sort(graph_bfs[i]);
        }

        dfs(v);
        System.out.println();
        bfs(v);

        br.close();
    }

    private static void dfs(int start) {
        visited_dfs[start] = true; // 현재 정점을 방문한 것으로 표시
        System.out.print(start + " "); // 현재 정점 출력

        for (int i : graph_dfs[start]) {
            if (!visited_dfs[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited_bfs[start] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();
            System.out.print(now + " ");
            for (int i:graph_bfs[now]){
                if (!visited_bfs[i]){
                    queue.add(i);
                    visited_bfs[i] = true;
                }
            }
        }
    }
}
