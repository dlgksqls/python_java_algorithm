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
            int son = 0;
            boolean flag = true;
            int time = 0;

            while(true){
                if (time != 0 && time % m == 0){
                    bung += k;
                }
                if (time < array[son]) {
                    time ++;
                    continue;
                }
                else if(bung == 0){
                    flag = false;
                    break;
                }
                son ++;
                bung --;
                time ++;
                if (son == array.length) break;
            }

            String answer = (flag) ? "Possible" : "Impossible";

            System.out.println("#" + tc + " " + answer);
        }
    }
}
