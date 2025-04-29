import java.util.*;

public class Solution {

    static long min;
    static long max;
    static char[] input;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            input = sc.next().toCharArray();

            long number = StringToLong(input);

            min = number;
            max = number;

            for (int i = 0; i < input.length; i++) {
                for (int j = i + 1; j < input.length; j++) {
                    swap(i, j);
                    if (input[0] != '0') {
                        long now = StringToLong(input);
                        min = Math.min(min, now);
                        max = Math.max(max, now);
                    }
                    swap(i, j);
                }
            }

            System.out.println("#" + tc + " " + min + " " + max);
        }
    }

    private static void swap(int i, int j) {
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    private static long StringToLong(char[] input) {
        String long_str = "";
        for(int i=0; i<input.length; i++){
            long_str += input[i];
        }
        return Long.parseLong(long_str);
    }
}