import java.util.*;
import java.io.*;
public class Main {

    static int n;
    static ArrayList<Integer>[] graph;
    static int[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        visited = new int[n+1];
        result = new int[n+1];

        for (int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i=1; i<=n; i++){
            if (visited[i] != 1) {
                dfs(i);
            }
        }
        for(int i=2; i<=n; i++){
            System.out.println(result[i]);
        }
    }

    private static void dfs(int v) {
        visited[v] = 1;

        for (int i : graph[v]){
            if (visited[i] != 1) {
                result[i] = v;
                dfs(i);
            }
        }
    }
}
