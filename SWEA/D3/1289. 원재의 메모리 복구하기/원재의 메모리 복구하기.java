import java.util.*;

public class Solution {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            String input = sc.next();
            StringBuilder sb = new StringBuilder();

            String result = repeat(input.length(), sb, 0).toString();
            int answer = 0;

            for(int i=0; i<input.length(); i++){
                sb = new StringBuilder();
                
                if (input == result) break;
                if (input.charAt(i) == result.charAt(i)) continue;
                
                if (input.charAt(i) == '1'){
                    result = result.substring(0, i) + repeat(input.length()-i, sb, 1);
                    answer ++;
                }
                else if (input.charAt(i) == '0'){
                    result = result.substring(0, i) + repeat(input.length()-i, sb, 0);
                    answer ++;
                }
            }
            System.out.println("#" + tc + " " + answer);
        }
    }

    private static StringBuilder repeat(int len, StringBuilder sb, int number) {
        for(int i = 0; i< len; i++) sb.append(number);
        return sb;
    }
}
