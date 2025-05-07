import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int tc = 1; tc <= 10; tc ++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            graph = new ArrayList[100];
            for(int i=0; i<100; i++){
                graph[i] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<m; i++){
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x].add(y);
            }

            flag = false;
            visited = new boolean[100];
            dfs(0);

            if (flag) System.out.println("#" + tc + " " + 1);
            else System.out.println("#" + tc + " " + 0);
        }

        br.close();
    }

    private static void dfs(int v) {
        if (v == 99){
            flag = true;
            return;
        }
        visited[v] = true;

        for (Integer i : graph[v]) {
            if (!visited[i]){
                dfs(i);
            }
        }
    }
}
