import java.util.Scanner;

/**
 * 구간 합
 * 1. 합 배열 구하기 (S[i] = A[0] + A[2] + _ + A[i];
 * 2. 합 배열 공식 S[i] = S[i-1] + A[i];
 * 3. 구간 합 구하는 공식 S[j] - S[i-1] // i에서 j까지 구간 합
 */
public class Main {
    /**
     * 첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다. 둘째 줄에는 N개의 수가 주어진다. 수는 1,000보다 작거나 같은 자연수이다.
     * 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arrays = new int[n+1];
        int[] sum = new int[n+1];

        for (int i=0; i<n; i++){
            arrays[i+1] = sc.nextInt();
        }

        for (int i=1; i<n+1; i++){
            sum[i] = sum[i-1] + arrays[i];
        }

        for (int i=0; i<m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(sum[y] - sum[x-1]);
        }
    }
}
