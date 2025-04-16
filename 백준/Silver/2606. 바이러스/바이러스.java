import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean visited[];
    static int n, m;
    static int answer = 0;
    static Queue<Integer> queue;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        bfs(1);
        System.out.println(answer);

        br.close();
    }

    private static void bfs(int node) {
        queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;

        while (!queue.isEmpty()){
            int v = queue.poll();
            for (Integer i: graph[v]) {
                if (!visited[i]){
                    visited[i] = true;
                    answer ++;
                    queue.offer(i);
                }
            }
        }
    }
}
