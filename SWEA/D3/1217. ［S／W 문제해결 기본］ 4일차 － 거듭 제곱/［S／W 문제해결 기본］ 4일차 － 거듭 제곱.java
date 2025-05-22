import java.util.Scanner;

public class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc ++){
            int n = sc.nextInt();

            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println("#" + tc + " " + recursion(a, b));
        }
    }

    private static int recursion(int a, int b) {
        if (b == 1) return a;
        return a * recursion(a, b - 1);
    }
}
