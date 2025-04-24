import java.util.*;

public class Solution {

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {
            int n = sc.nextInt();
            int answer;
            int[][] graph = new int[100][100];

            for(int i=0; i<100; i++){
                for(int j=0; j<100; j++){
                    graph[i][j] = sc.nextInt();
                }
            }

            int cl_sum = 0;
            int cr_sum = 0;
            for(int i=0; i<100; i++){
                cl_sum += graph[i][i];
                cr_sum += graph[i][99-i];
            }
            answer = Math.max(cl_sum, cr_sum);

            for(int i=0; i<100; i++){
                int r_sum = 0;
                int c_sum = 0;
                for(int j=0; j<100; j++){
                    r_sum += graph[i][j];
                    c_sum += graph[j][i];
                }
                answer = Math.max(answer, r_sum);
                answer = Math.max(answer, c_sum);
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}
