import java.util.*;

public class Solution {

    static int n;
    static int m;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int answer;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            n = sc.nextInt();
            m = sc.nextInt();
            answer = 0;

            visited = new boolean[n+1];
            graph = new ArrayList[n+1];
            for(int i=1; i<=n; i++){
                graph[i] = new ArrayList();
            }

            for(int i=0; i<m; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();

                graph[x].add(y);
                graph[y].add(x);
            }

            for(int i=1; i<=n; i++){
                dfs(i, 1);
            }

            System.out.println("#" + tc + " " + answer);
        }
    }

    private static void dfs(int v, int depth) {
        visited[v] = true;
        answer = Math.max(answer, depth);

        for (Integer i : graph[v]) {
            if (!visited[i]){
                dfs(i, depth+1);
            }
        }
        visited[v] = false;
    }
}
