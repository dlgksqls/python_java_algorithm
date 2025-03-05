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
    static int[] answer;
    static int count;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        answer = new int[n+1];

        for(int i=0; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            count = 0;
            visited = new boolean[n + 1];
//            dfs(i);
            bfs(i);
            answer[i] = count;
//            System.out.println(answer[i]);
        }

        for (int i=1; i<=n; i++){
            if (max < answer[i]){
                max = answer[i];
            }
        }

        for (int i=1; i<=n; i++){
            if (answer[i] == max){
                System.out.println(i);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()){
            int now = queue.poll();

            for (int i : graph[now]) {
                if (!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                    count ++;
                }
            }
        }
    }

    private static void dfs(int v) {
        visited[v] = true;

        for (int node : graph[v]) {
            if (!visited[node]){
                count ++;
                dfs(node);
                }
            }
        }
    }
