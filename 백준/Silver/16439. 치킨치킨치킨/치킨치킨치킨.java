import java.util.*;
import java.io.*;
public class Main {
    static int n, m;
    static int answer;
    static int graph[][];
    static boolean visited[];

    public static void dfs(int start, int depth){
        if (depth == 3){
            int sum = 0;

            for (int i=0; i<n; i++){
                int temp = 0;
                for (int j=0; j<m; j++){
                    if (visited[j])
                        temp = Math.max(temp, graph[i][j]);
                }
                sum += temp;
            }
            answer = Math.max(sum, answer);
        }
        else{
            for(int i=start; i<m; i++){
                if(!visited[i]) {
                    visited[i] = true;
                    dfs(i + 1, depth + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[m];

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(answer);

        br.close();
    }
}
