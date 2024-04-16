import java.util.*;
import java.io.*;
public class Main {
    static boolean[][] graph;
    static boolean[] visited;
    static int N, M;
    static int answer;

    public static void dfs(int idx){
        visited[idx] = true;
        answer ++;

        for (int i=0; i<=N; i++){
            if(visited[i] == false && graph[idx][i] == true){
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        // 1. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); // br.readLine() 한 줄 입력받음
        M = Integer.parseInt(br.readLine());

        graph = new boolean[N+1][N+1];
        visited = new boolean[N+1];

        // 2. graph에 연결 정보 채우기
        int x, y;
        for (int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()); // 한 줄에 입력받은 것을 string으 뛰어쓰기 해서 나눠줌
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }

        // 3. dfs(재귀 함수) 호출
        dfs(1);

        // 4. 출력
        bw.write(String.valueOf(answer - 1));

        br.close();
        bw.close();
    }
}
