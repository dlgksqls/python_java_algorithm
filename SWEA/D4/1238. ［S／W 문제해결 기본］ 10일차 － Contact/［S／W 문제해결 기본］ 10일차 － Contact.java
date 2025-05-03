import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int n, m;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int tc = 1; tc <= 10; tc ++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            graph = new ArrayList[101];
            visited = new boolean[101];

            for(int i=1; i<=100; i++){
                graph[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n/2; i++){
                graph[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
            }

            int answer = bfs(m);
            System.out.println("#" + tc + " " + answer);
        }

        br.close();
    }

    private static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        int max = start;

        while (!queue.isEmpty()) {
            PriorityQueue<Integer> nodes = new PriorityQueue<>(Collections.reverseOrder());
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int now = queue.poll();
                nodes.add(now);

                for (int next : graph[now]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }

            max = nodes.poll();
        }

        return max;
    }
}
