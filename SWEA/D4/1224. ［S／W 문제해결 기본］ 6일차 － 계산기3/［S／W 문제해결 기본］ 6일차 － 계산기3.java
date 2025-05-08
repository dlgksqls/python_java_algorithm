import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc = 1; tc <= 10; tc ++){
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();

            HashMap<Character, Integer> map = new HashMap<>();
            map.put('*', 1);
            map.put('+', 2);
            map.put('(', 3);

            Stack<Character> stack = new Stack<>();
            String answer = "";

            for (int i = 0; i < n; i++) {
                char now = input.charAt(i);
                if (Character.isDigit(now)) {
                    answer += now;
                } else if (now == '(') {
                    stack.push(now);
                } else if (now == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        answer += stack.pop();
                    }
                    stack.pop();
                } else {
                    while (!stack.isEmpty() && map.get(stack.peek()) <= map.get(now)) {
                        answer += stack.pop();
                    }
                    stack.push(now);
                }
            }
            while (!stack.isEmpty()) {
                answer += stack.pop();
            }

            Stack<Integer> op_stack = new Stack<>();
            for(int i=0; i<answer.length(); i++){
                char now = answer.charAt(i);
                if (Character.isDigit(now)){
                    op_stack.push(now - '0');
                }
                else if (now == '+'){
                    int first = op_stack.pop();
                    int second = op_stack.pop();

                    op_stack.push(first + second);
                }
                else if (now == '*'){
                    int first = op_stack.pop();
                    int second = op_stack.pop();

                    op_stack.push(first * second);
                }
            }

            System.out.println("#" + tc + " " + op_stack.pop());
        }
        br.close();
    }
}
