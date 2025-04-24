import java.util.*;

public class Solution {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();

            int[] array = new int[n];

            for(int i=0; i<n; i++){
                array[i] = sc.nextInt();
            }

            Arrays.sort(array);

            int bung = 0;
            int count = 0;
            boolean flag = true;
            int idx = 0;

            while (count <= array[array.length-1]){
                if (array[0] == 0) {
                    flag = false;
                    break;
                }
                if (count != 0 && count % m == 0) bung += k;
                if (array[idx] == count && bung > 0) {
                    bung--;
                    idx ++;
                }
                else if (array[idx] == count && bung == 0) {
                    flag = false;
                    break;
                }
                count ++;
            }

            if (flag){
                System.out.println("#" + tc + " " + "Possible");
            }
            else {
                System.out.println("#" + tc + " " + "Impossible");
            }
        }
    }
}
