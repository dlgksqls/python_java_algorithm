import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int count=0;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static boolean arrive;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n];
        visited = new boolean[n];

        for (int i=0; i<n; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i=0; i<n; i++){
            dfs(i, 1);

            if (arrive){
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    private static void dfs(int v, int depth) {
        if (depth == 5 || arrive){
            arrive = true;
            return;
        }

        visited[v] = true;
        for (int i:graph[v]){
            if (!visited[i]){
                dfs(i, depth+1);
            }
        }
        visited[v] = false;
    }
}
