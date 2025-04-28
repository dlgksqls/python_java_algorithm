import java.util.*;

public class Solution {

    static int n;
    static int[] array;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            array = new int[7];
            n = sc.nextInt();
            for (int i = 0; i < 7; i++) {
                array[i] = sc.nextInt();
            }

            int answer = Integer.MAX_VALUE;

            for(int i=0; i<7; i++){
                int day = 0;
                int idx = i;
                int count = 0;

                while(day != n){
                    if (array[idx % 7] == 1){
                        day ++;
                    }
                    count ++;
                    idx ++;
                }

                answer = Math.min(answer, count);
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}
