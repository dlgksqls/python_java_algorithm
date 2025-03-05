import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int k;
    static int x;
    static ArrayList<Integer>[] graph;
    static int[] visited;
    static ArrayList<Integer> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        visited = new int[n+1];
        answer = new ArrayList<>();

        for (int i=0; i<n+1; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<n+1; i++){
            visited[i] = -1;
        }

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
        }

        bfs(x);

        for(int i=1; i<n+1; i++){
            if (visited[i] == k){
                answer.add(i);
            }
        }

        if (answer.isEmpty()){
            System.out.println(-1);
        }
        else{
            for (Integer i : answer) {
                System.out.println(i);
            }
        }
        br.close();
    }

    private static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        visited[x]++;
        queue.add(x);

        while(!queue.isEmpty()){
            int now_node = queue.poll();
            for (int i : graph[now_node]) {
                if (visited[i] == -1){
                    visited[i] = visited[now_node] + 1;
                    queue.add(i);
                }
            }
        }
    }
}
