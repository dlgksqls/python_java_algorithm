import java.util.*;
import java.io.*;
public class Main {
    static int graph [][];
    static int m, n;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static String answer = "NO";

    public static void dfs(int x, int y){
        graph[x][y] = 1;
        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx>=0 && nx<m && ny>=0 && ny<n){
                if (graph[nx][ny] == 0) {
                    if (nx == m - 1) {
                        answer = "YES";
                        return;
                    }
                    dfs(nx, ny);
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        graph = new int[m][n];

        for (int i=0; i<m; i++){
            String str = br.readLine();
            for (int j=0; j<n; j++)
                graph[i][j] = str.charAt(j) - '0';
        }

        for (int i=0; i<n; i++){
            if (graph[0][i] == 0){
                dfs(0, i);
                if (answer.equals("YES"))
                    break;
            }
        }

        bw.write(answer);

        br.close();
        bw.close();
    }
}
