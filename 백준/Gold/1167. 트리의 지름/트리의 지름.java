import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] distance;
    static boolean[] visited;
    static ArrayList<edge>[] graph;

    static class edge{
        private int e;
        private int val;

        public edge(int e, int val) {
            this.e = e;
            this.val = val;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];

        for (int i=0; i<n+1; i++){
            graph[i] = new ArrayList<edge>();
        }

        for(int i=1; i<n+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());

            while (true){
                int e = Integer.parseInt(st.nextToken());
                if (e == -1) {
                    break;
                }
                int v = Integer.parseInt(st.nextToken());
                graph[s].add(new edge(e, v));
            }
        }
        distance = new int[n+1];
        visited = new boolean[n+1];

        bfs(1);

        int max = 1;
        for(int i=2; i<n+1; i++){
            if (distance[max] < distance[i]){
                max = i;
            }
        }
        distance = new int[n+1];
        visited = new boolean[n+1];
        bfs(max);
        Arrays.sort(distance);
        System.out.println(distance[n]);
        br.close();
    }

    private static void bfs(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;

        while (!queue.isEmpty()){
            int index = queue.poll();

            for (edge edge : graph[index]){
                int e = edge.e;
                int v = edge.val;
                if (!visited[e]){
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[index] + v;
                }
            }
        }
    }
}
