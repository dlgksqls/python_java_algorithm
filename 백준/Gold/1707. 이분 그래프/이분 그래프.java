import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static int v;
    static int e;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] color; // 미방문 : 0, 빨강 : 1, 검정 : -1
    static boolean isEven;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());

        while (k>0){
            k --;
            isEven = true;

            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            graph = new ArrayList[v+1];
            visited = new boolean[v+1];
            color = new int[v+1];

            for (int i=0; i<=v; i++){
                graph[i] = new ArrayList<>();
            }

            for (int i=0; i<e; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a].add(b);
                graph[b].add(a);
            }

            for (int i=1; i<=v; i++){
                if (!visited[i]) {
                    color[i] = 1;
                    dfs(i);
                }
                if (!isEven)
                    break;
            }

            if (isEven){
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }

    private static void dfs(int start) {
        visited[start] = true;

        for (Integer now : graph[start]) {
            if (!visited[now]){
                color[now] = -color[start];
                dfs(now);
            }
            else if (color[start] == color[now]){
                isEven = false;
                return;
            }
        }
    }
}
