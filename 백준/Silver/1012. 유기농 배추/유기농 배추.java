import java.util.*;
import java.io.*;
public class Main {
    static int graph[][];
    static int t, m, n, k;
    static int answer;
    static int answers[];

    public static void dfs(int y, int x){
        graph[y][x] = 0;
        int dx[] = {1, 0, -1, 0};
        int dy[] = {0, 1, 0, -1};

        for (int i=0; i<4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= 0 && nx < m && ny >= 0 && ny < n)
                if (graph[ny][nx] == 1){
                    dfs(ny,nx);
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(br.readLine());
        answers = new int[t];
        for (int i=0; i<t; i++){
            answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            graph = new int[n][m];

            for (int j=0; j<k; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[y][x] = 1;
            }

            for (int j=0; j<n; j++) {
                for (int l=0; l<m; l++){
                    if (graph[j][l] == 1){
                        answer++;
                        dfs(j ,l);
                    }
                }
            }
            answers[i] = answer;
        }

        for (int answer : answers) {
            System.out.println(answer);
        }

        br.close();
        bw.close();
    }
}
