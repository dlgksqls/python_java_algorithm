import java.util.*;
import java.io.*;

public class Main {
    static final int max = 100+10;
    static int n;
    static int start, end;
    static int num;
    static int answer = -1;

    static boolean visited[];
    static boolean graph[][];

    public static void dfs(int idx, int count){
        visited[idx] = true;
        if (idx == end){
            answer = count;
            return;
        }

        for (int i=1; i<=n; i++){
            if (visited[i] == false && graph[idx][i] == true) {
                dfs(i, count+1);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        num = Integer.parseInt(br.readLine());

        graph = new boolean[max][max];
        visited = new boolean[max];


        for (int i=0; i<num; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }

        dfs(start, 0);

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
