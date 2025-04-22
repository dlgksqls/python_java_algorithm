import java.util.*;

public class Solution {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for(int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int answer = 0;
            int[][] graph = new int[100][100];

            for(int i=0; i<100; i++){
                for(int j=0; j<100; j++) {
                    graph[i][j] = sc.nextInt();
                }
            }

            for(int i=0; i<100; i++){
                boolean flag = false;
                for(int j=0; j<100; j++){
                    if (graph[j][i] == 1) flag = true;
                    if (flag && graph[j][i] == 2) {
                        answer++;
                        flag = false;
                    }
                }
            }
            System.out.println("#" + tc + " " + answer);
        }
    }
}
