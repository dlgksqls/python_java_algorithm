import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] result;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        result = new int[n+1];

        for (int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[b].add(a);
        }

        for(int i=1; i<=n; i++){
            count = 0;
            visited = new boolean[n+1];
            bfs(i);
            result[i] = count;
        }

        int max = 0;
        for (int i : result){
            if (max < i) max = i;
        }

        for (int i=1; i<=n; i++){
            if (result[i] == max) System.out.println(i);
        }

        br.close();
    }

    private static void bfs(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);

        visited[i] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();
            for (int v : graph[now]){
                if (!visited[v]){
                    visited[v] = true;
                    queue.add(v);
                    count ++;
                }
            }
        }
    }
}
