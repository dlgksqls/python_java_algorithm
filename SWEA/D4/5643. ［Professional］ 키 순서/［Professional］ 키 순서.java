import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int n;
    static int[][] graph;
    static boolean[] visited;
    static int rCount;
    static int hCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc ++){
            n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());

            graph = new int[n+1][n+1];


            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a][b] = 1;
            }

            int answer = 0;

            for(int i=1; i<=n; i++){
                rCount = 0;
                hCount = 0;
                visited = new boolean[n+1];
                rdfs(i);
                visited = new boolean[n+1];
                hdfs(i);

                if (rCount + hCount == n-1) answer ++;
            }

            System.out.println("#" + tc + " " + answer);
        }
        br.close();
    }

    private static void hdfs(int idx) {
        visited[idx] = true;

        for(int i=1; i<=n; i++){
            if (!visited[i] && graph[idx][i] == 1) {
                rCount++;
                hdfs(i);
            }
        }
    }

    private static void rdfs(int idx) {
        visited[idx] = true;

        for(int i=1; i<=n; i++){
            if (!visited[i] && graph[i][idx] == 1) {
                rCount++;
                rdfs(i);
            }
        }
    }
}
