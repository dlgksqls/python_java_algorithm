import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static int graph[][];
    static String answer = "Hing";
    public static void dfs(int x, int y){
        if (graph[x][y] == -1){
            answer = "HaruHaru";
            return;
        }
        int cur = graph[x][y];

        graph[x][y] = -2;

        int dx[] = {0, cur};
        int dy[] = {cur, 0};

        for (int i=0; i<2; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx>=0 && nx<n && ny>=0 && ny<n){
                if (graph[nx][ny] != -2)
                    dfs(nx, ny);
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];

        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
