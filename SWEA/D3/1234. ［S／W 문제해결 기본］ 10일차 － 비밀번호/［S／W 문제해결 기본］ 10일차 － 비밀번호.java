import java.util.*;

public class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int n = sc.nextInt();
            String s = sc.next();
            Stack<Character> stack = new Stack<>();

            for (char c : s.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop(); // 중복 제거
                } else {
                    stack.push(c);
                }
            }

            System.out.print("#" + tc + " ");
            for (char c : stack) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}