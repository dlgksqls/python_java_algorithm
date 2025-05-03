import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int n, m;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static PriorityQueue<Integer> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int tc = 1; tc <= 10; tc ++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            graph = new ArrayList[101];
            visited = new boolean[101];
            answer = new PriorityQueue<>(Collections.reverseOrder());

            for(int i=1; i<=100; i++){
                graph[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n/2; i++){
                graph[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
            }

            bfs(m);

            System.out.println("#" + tc + " " + answer.poll());
        }

        br.close();
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            PriorityQueue<Integer> nodes = new PriorityQueue<>(Collections.reverseOrder());
            int size = queue.size(); // 큐의 크기가 바뀌므로 고정시켜야함

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

            answer = nodes;
        }
    }
}
