import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] score = new int[n];
        double answer = 0;
        double avg = 0;

        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
        }

        Arrays.sort(score);

        for (int i : score) {
            avg += i;
        }

        answer = avg * 100 / score[n-1] / n;
        System.out.println(answer);
    }
}
