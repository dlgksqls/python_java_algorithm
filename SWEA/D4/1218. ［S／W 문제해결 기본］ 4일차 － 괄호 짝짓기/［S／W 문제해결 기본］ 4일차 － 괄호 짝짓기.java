import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc = 1; tc <= 10; tc ++) {
            int n = Integer.parseInt(br.readLine());
            char[] array = br.readLine().toCharArray();

            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                char ch = array[i];
                if (ch == '(' || ch == '{' || ch == '<' || ch == '[') stack.push(ch);
                else{
                    char top = stack.pop();
                    if(
                            (ch == ')' && top != '(') ||
                            (ch == '}' && top != '{') ||
                            (ch == ']' && top != '[') ||
                            (ch == '>' && top != '<')
                    ){
                        flag = false;
                        break;
                    }
                }
            }

            if (flag) System.out.println("#" + tc + " " + 1);
            else System.out.println("#" + tc + " " + 0);
        }
    }
}
