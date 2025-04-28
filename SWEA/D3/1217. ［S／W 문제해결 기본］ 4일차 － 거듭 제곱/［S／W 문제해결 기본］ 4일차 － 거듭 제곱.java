import java.util.Scanner;

public class Solution {

    static int answer;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {
            int n = sc.nextInt();
            answer = 1;
            recursion(0, sc.nextInt(), sc.nextInt());
            System.out.println("#" + n + " " + answer);
        }
    }

    private static void recursion(int idx, int x, int y) {
        if (idx == y) {
            return;
        }
       
        answer *= x;
        recursion(idx + 1, x, y);
    }
}
