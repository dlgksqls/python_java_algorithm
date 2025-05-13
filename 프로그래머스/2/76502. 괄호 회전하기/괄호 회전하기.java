import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            String rotated = s.substring(i) + s.substring(0, i);
            if (check(rotated)) {
                answer++;
            }
        }

        return answer;
    }

    public boolean check(String str) {
        Stack<Character> stack = new Stack<>();

        for (char chr : str.toCharArray()) {
            if (chr == '(' || chr == '{' || chr == '[') {
                stack.push(chr);
            } else {
                if (stack.isEmpty()) return false;
                char now = stack.pop();
                if ((chr == ')' && now != '(') ||
                    (chr == '}' && now != '{') ||
                    (chr == ']' && now != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}