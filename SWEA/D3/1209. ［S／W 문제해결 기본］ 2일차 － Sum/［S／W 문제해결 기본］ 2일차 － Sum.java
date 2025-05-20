import java.util.*;

public class Solution {

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {
            int n = sc.nextInt();
            int answer = Integer.MIN_VALUE;
            int[][] array = new int[100][100];

            for(int i=0; i<100; i++){
                for(int j=0; j<100; j++){
                    array[i][j] = sc.nextInt();
                }
            }

            for(int i=0; i<100; i++){
                int rSum = 0;
                int cSum = 0;
                for(int j=0; j<100; j++){
                    rSum += array[i][j];
                }
                for(int j=0; j<100; j++){
                    cSum += array[j][i];
                }
                answer = Math.max(answer, Math.max(rSum, cSum));
            }

            int crSum = 0;
            int clSum = 0;
            for(int i=0; i<100; i++){
                crSum += array[i][i];
                clSum += array[i][99 - i];
            }

            answer = Math.max(answer, Math.max(crSum, clSum));
            System.out.println("#" + tc + " " + answer);
        }
    }
}
