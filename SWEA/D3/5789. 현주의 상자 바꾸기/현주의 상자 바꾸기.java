import java.util.*;

public class Solution {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            int[] array = new int[n+1];
            for(int i=1; i<=q; i++){
                int l = sc.nextInt();
                int r = sc.nextInt();

                for(int j=l; j<=r; j++){
                    array[j] = i;
                }
            }

            System.out.print("#" + tc + " ");
            for(int i=1; i<=n; i++){
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }
}