import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static ArrayList<Edge>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        // 다익스트라
        int answer = 0;
        int cnt = 0;

        PriorityQueue<Edge> queue = new PriorityQueue();
        queue.add(new Edge(1, 0));

        while(!queue.isEmpty()){
            if (cnt == n) break;
            Edge poll = queue.poll();
            int node = poll.node;
            int weight = poll.value;

            if (!visited[node]){
                visited[node] = true;
                answer += weight;
                cnt += 1;

                for (Edge edge : graph[node]) {
                    queue.add(new Edge(edge.node, edge.value));
                }
            }
        }
        System.out.println(answer);
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
            if (this.value > edge.value) return 1;
            else return -1;
        }
    }
}
