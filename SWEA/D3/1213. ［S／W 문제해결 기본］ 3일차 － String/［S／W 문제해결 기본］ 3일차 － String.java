import java.util.*;

public class Solution {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {
            int n = sc.nextInt();

            String find = sc.next();
            String input = sc.next();
            int answer = 0;

            int start = 0;
            int end = find.length() - 1;

            while(end < input.length()){
                if (input.substring(start, end + 1).equals(find)) answer ++;
                start ++;
                end ++;
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}
