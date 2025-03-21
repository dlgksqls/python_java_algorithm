import java.util.*;
import java.io.*;
public class Main {

    static int n;
    static int m;
    static ArrayList<Integer>[] graph;
    static int[] visited;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        visited = new int[n+1];

        for (int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1);

        System.out.println(count);
        br.close();
    }

    private static void dfs(int v) {
        visited[v] = 1;

        for (int i : graph[v]) {
            if (visited[i] != 1){
                count++;
                dfs(i);
            }
        }
    }
}
