import java.util.*;

public class Solution {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {
            int n = sc.nextInt();
            String find = sc.next();
            String input = sc.next();

            int answer = 0;
            int find_len = find.length();
            int start = 0;
            int end = find_len-1;

            while(end <= input.length()-1){
                boolean flag = true;
                int count = 0;
                for(int i=start; i<=end; i++){
                    if (find.charAt(count) != input.charAt(i)) {
                        flag = false;
                        break;
                    }
                    count ++;
                }
                start ++;
                end ++;

                if (flag) {
                    answer++;
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}
