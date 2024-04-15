import java.util.*;
import java.io.*;
public class Main {
    static boolean graph[][];
    static boolean visited_dfs[];
    static boolean visited_bfs[];
    static ArrayList<Integer> queue;
    static int n, m, v;

    public static void dfs(int idx){
        visited_dfs[idx] = true;
        System.out.print(idx + " ");

        for (int i=1; i<=n; i++){
            if (!visited_dfs[i] && graph[idx][i])
                dfs(i);
        }
    }

    public static void bfs(){
        queue = new ArrayList<>();

        queue.add(v);
        visited_bfs[v] = true;

        while(!queue.isEmpty()){
            int idx = queue.remove(0);
            System.out.print(idx + " ");

            for (int i=1; i<=n; i++){
                if (!visited_bfs[i] && graph[idx][i]){
                    queue.add(i);
                    visited_bfs[i] = true;
                    }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new boolean[n+1][n+1];
        visited_dfs = new boolean[n+1];
        visited_bfs = new boolean[n+1];

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }

        dfs(v);
        System.out.println();
        bfs();
    }
}
