import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /**
     * 어떠한 자연수 N은, 몇 개의 연속된 자연수의 합으로 나타낼 수 있다.
     * 당신은 어떤 자연수 N(1 ≤ N ≤ 10,000,000)에 대해서, 이 N을 몇 개의 연속된 자연수의 합으로 나타내는 가지수를 알고 싶어한다.
     * 이때, 사용하는 자연수는 N이하여야 한다.
     *
     * 입력
     * 첫 줄에 정수 N이 주어진다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int result = 1;
        int sum = 1;
        int start_index = 1;
        int end_index = 1;

        while (end_index != n){
            if (sum == n){
                result ++;
                end_index ++;
                sum += end_index;
            }
            else if (sum < n){
                end_index ++;
                sum += end_index;
            }
            else if (sum > n){
                sum -= start_index;
                start_index ++;
            }
        }
        System.out.println(result);
    }
}
