import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i=0; i<=n; i++){
            Collections.sort(graph[i]);
        }

        visited = new boolean[n + 1];
        dfs(v);

        System.out.println();
        visited = new boolean[n + 1];
        bfs(v);

        br.close();
    }

    private static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int i : graph[v]) {
            if (!visited[i]){
                visited[i] = true;
                dfs(i);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while(!queue.isEmpty()){
            int poll = queue.poll();
            System.out.print(poll + " ");

            for (int i : graph[poll]) {
                if (!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
