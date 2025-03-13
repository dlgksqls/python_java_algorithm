import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] distance;
    static boolean[] visited;
    static ArrayList<Edge>[] graph;
    static PriorityQueue<Edge> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        distance = new int[n+1];
        visited = new boolean[n+1];
        graph = new ArrayList[n+1];

        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v, cost));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        distance[start] = 0;
        queue.add(new Edge(start, 0));

        while (!queue.isEmpty()){
            Edge node = queue.poll();
            int now_node = node.node;

            if (!visited[now_node]) {
                visited[now_node] = true;
                for (int i = 0; i < graph[now_node].size(); i++) {
                    Edge edge = graph[now_node].get(i);
                    int next = edge.node;
                    int value = edge.value;

                    if (!visited[next] && distance[next] > distance[now_node] + value) {
                        distance[next] = distance[now_node] + value;
                        queue.add(new Edge(next, distance[next]));
                    }
                }
            }
        }
        System.out.println(distance[end]);
        br.close();
    }

    private static class Edge implements Comparable<Edge>{
        int node;
        int value;

        public Edge(int node, int value) {
            this.node = node;
            this.value = value;
        }

        @Override
        public int compareTo(Edge edge) {
            if (this.value > edge.value){
                return 1;
            }
            else return -1;
        }
    }
}
