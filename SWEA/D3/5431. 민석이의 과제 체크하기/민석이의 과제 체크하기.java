import java.util.*;

public class Solution {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            boolean[] array = new boolean[n+1];

            for(int i=0; i<k; i++){
                int num = sc.nextInt();
                array[num] = true;
            }

            System.out.print("#" + tc + " ");
            for(int i=1; i<=n; i++){
                if (!array[i]) System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
