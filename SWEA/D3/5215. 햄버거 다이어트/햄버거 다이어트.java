import java.util.*;

public class Solution {

    static int n;
    static int l;
    static ArrayList<Ingre> array;
    static int answer;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            answer = Integer.MIN_VALUE;
            n = sc.nextInt();
            l = sc.nextInt();

            array = new ArrayList<>();

            for(int i=0; i<n; i++){
                array.add(new Ingre(sc.nextInt(), sc.nextInt()));
            }

            recursion(0, 0, 0);

            System.out.println("#" + tc + " " + answer);
        }
    }

    private static void recursion(int idx, int score, int kal) {

        if (idx == n){
            answer = Math.max(score, answer);
            return;
        }

        if (kal + array.get(idx).kal <= l) {
            recursion(idx + 1, score + array.get(idx).score, kal + array.get(idx).kal);
        }
        recursion(idx + 1, score, kal);
    }

    private static class Ingre {
        int score;
        int kal;

        public Ingre(int score, int kal) {
            this.score = score;
            this.kal = kal;
        }
    }
}
