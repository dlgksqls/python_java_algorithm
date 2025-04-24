import java.util.*;

public class Solution {

    static int answer;
    static int k;
    static int[] array;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            k = sc.nextInt();
            answer = 0;

            array = new int[n];
            for(int i=0; i<n; i++){
                array[i] = sc.nextInt();
            }

            recursion(0, 0);

            System.out.println("#" + tc + " " + answer);
        }
    }

    private static void recursion(int sum, int depth) {
        if (sum == k){
            answer ++;
            return;
        }

        if (depth == array.length){
            return;
        }

        // 선택하거나
        recursion(sum + array[depth], depth + 1);

        // 안하거나
        recursion(sum, depth + 1);
    }
}
