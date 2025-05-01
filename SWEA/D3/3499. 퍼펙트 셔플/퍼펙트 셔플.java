import java.util.*;

public class Solution {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            String[] array = new String[n];
            String[] answer = new String[n];
            for(int i=0; i<n; i++){
                array[i] = sc.next();
            }

            int start = 0;
            int end = (n % 2) == 0 ? n/2 : n/2+1;
            int idx = 0;
            while(end < n){
                answer[idx++] = array[start];
                answer[idx++] = array[end];

                start ++;
                end ++;
            }

            if (end % 2 != 0)
                answer[n-1] = array[start];

            System.out.print("#" + tc + " ");
            for (String i : answer) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
