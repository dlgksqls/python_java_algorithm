import java.io.*;
import java.util.*;
public class Main {
    static int w, h;
    static int answer;
    static String input;
    static Integer graph[][];
    static int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};
    static int dy[] = {1, 1, 0, -1, -1, -1, 0, 1};
    public static void dfs(int x, int y) {
        graph[x][y] = 0;

        for (int i = 0; i < 8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx>=0 && nx<h && ny>=0 && ny<w){
                if (graph[nx][ny] == 1){
                    dfs(nx, ny);
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true){
                answer = 0;
               StringTokenizer st = new StringTokenizer(br.readLine());
               w = Integer.parseInt(st.nextToken());
               h = Integer.parseInt(st.nextToken());

               graph = new Integer[h][w];

               if (w == 0 && h == 0)
                   break;
               else{
                   for (int i=0; i<h; i++){
                       st = new StringTokenizer(br.readLine()); // 이 줄을 for문 안에 넣어서 각 줄마다 새로운 StringTokenizer 객체를 생성합니다.
                       for (int j=0; j<w; j++){
                           graph[i][j] = Integer.parseInt(st.nextToken()); // 공백으로 구분된 각 숫자를 정수로 변환하여 저장합니다.
                       }
                   }
                    for (int i=0; i<h; i++) {
                        for (int j = 0; j < w; j++) {
                            if (graph[i][j] == 1) {
                                answer += 1;
                                dfs(i, j);
                            }
                        }
                    }
               }
            bw.write(answer + "\n");
        }
        br.close();
        bw.close();
    }
}
