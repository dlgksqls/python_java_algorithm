import java.util.*;

public class Solution {
    static int answer;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int [] array = new int[n];
            for(int i=0; i<n; i++){
                array[i] = sc.nextInt();
            }

            answer = 0;
            recursion(0, 0, k, array);

            System.out.println("#" + tc + " " + answer);
        }
    }

    private static void recursion(int idx, int sum, int k, int[] array) {
        if (idx == array.length) {
            if (sum == k) {
                answer++;
            }
            return;
        }

        recursion(idx + 1, sum + array[idx], k, array);

        recursion(idx + 1, sum, k, array);
    }
}
