import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static HashSet<String> answer;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc ++){
            graph = new int[4][4];
            answer = new HashSet<>();

            for(int i=0; i<4; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<4; j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<4; i++){
                for(int j=0; j<4; j++){
                    recursion(i, j, String.valueOf(graph[i][j]));
                }
            }
            System.out.println("#" + tc + " " + answer.size());
        }

        br.close();
    }

    private static void recursion(int x, int y, String sen) {
        if (sen.length() == 7) {
            answer.add(sen);
            return;
        }

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4){
                recursion(nx, ny, sen + (char)(graph[nx][ny] + '0'));
            }
        }
    }
}
