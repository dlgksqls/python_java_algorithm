import java.util.*;

public class Solution {
    static int n;
    static int pick;
    static double[] array;
    static String[] grades = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
    static int answer;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            n = sc.nextInt();
            pick = sc.nextInt();
            array = new double[n];

            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt() * 0.35 + sc.nextInt() * 0.45 + sc.nextInt() * 0.2;
            }

            double target = array[pick-1];

            Arrays.sort(array);

            for (int i = 0; i < n; i++) {
                if (array[i] == target) {
                    answer = (n-i-1)/(n/10);
                    break;
                }
            }

            System.out.println("#" + tc + " " + grades[answer]);
        }
    }
}
