import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제 이해 잘 하기,,,
 */
public class Main {

    static int n;
    static int m;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static boolean check = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n];
        visited = new boolean[n];

        for (int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i=0; i<n; i++){
            if (!visited[i]){
                dfs(i, 1);
            }
            if (check){
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    private static void dfs(int v, int depth) {
        if (depth == 5){
            check = true;
            return;
        }

        visited[v] = true;

        for (int now : graph[v]) {
            if (!visited[now]){
                dfs(now, depth + 1);
            }
        }
        visited[v] = false;
    }
}
