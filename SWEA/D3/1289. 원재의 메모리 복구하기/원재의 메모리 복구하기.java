import java.util.*;

public class Solution {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            String input = sc.next();
            String result = repeat(input.length(), '0');

            int answer = 0;

            for(int i=0; i<input.length(); i++){
                if (input == result) break;
                if (input.charAt(i) == result.charAt(i)) continue;
                if (input.charAt(i) == '0'){
                    result = result.substring(0, i) + repeat(input.length() - i, '0');
                }
                else if (input.charAt(i) == '1'){
                    result = result.substring(0, i) + repeat(input.length() - i, '1');
                }
                answer ++;
            }
            System.out.println("#" + tc + " " + answer);
        }
    }

    private static String repeat(int length, char chr) {
        String val = "";
        for(int i=0; i<length; i++){
            val += chr;
        }
        return val;
    }
}
