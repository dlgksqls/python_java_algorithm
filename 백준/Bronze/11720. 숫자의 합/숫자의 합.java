import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String input = sc.next();
        char[] input_char = input.toCharArray();
        int sum = 0;

        for (char c : input_char) {
            sum += c - '0'; // 문자열을 정수로.. ex '1' => 1  (int)c를 하게되면 아스키코드로 반환함
        }

        System.out.println(sum);
    }
}
