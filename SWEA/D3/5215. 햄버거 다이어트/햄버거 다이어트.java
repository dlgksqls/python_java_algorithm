import java.util.*;

public class Solution {

    static class ingredient{
        int score;
        int cal;

        public ingredient(int score, int cal) {
            this.score = score;
            this.cal = cal;
        }
    }
    static int answer;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int l = sc.nextInt();

            ingredient[] array = new ingredient[n];
            for(int i=0; i<n; i++){
                array[i] = new ingredient(sc.nextInt(), sc.nextInt());
            }

            answer = Integer.MIN_VALUE;
            recursion(0, 0, 0, l, array);

            System.out.println("#" + tc + " " + answer);
        }
    }

    private static void recursion(int idx, int score, int cal, int limit, ingredient[] array) {
        if (idx == array.length){
            if (cal <= limit){
                answer = Math.max(answer, score);
            }
            return;
        }

        if (cal < limit) {
            recursion(idx + 1, score + array[idx].score, cal + array[idx].cal, limit, array);
        }

        recursion(idx + 1, score, cal, limit, array);
    }
}
