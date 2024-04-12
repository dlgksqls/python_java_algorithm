import java.util.*;
import java.io.*;
public class Main {
    static char graph[][];
    static int n, m;
    static int answer;
    public static void dfs(int x, int y){
        char cur = graph[x][y];
        graph[x][y] = '0';

        if (cur == '-'){
            if ((y+1) < m){
                if (graph[x][y+1] == '-'){
                    dfs(x, y+1);
                }
            }
        }
        else if(cur == '|'){
            if ((x+1) < n){
                if (graph[x+1][y] == '|')
                    dfs(x+1, y);
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new char[n][m];

        for (int i=0; i<n; i++){
            String input = br.readLine();
            for (int j=0; j<m; j++){
                graph[i][j] = input.charAt(j);
            }
        }
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (graph[i][j] != '0') {
                    answer++;
                    dfs(i, j);
                }
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
