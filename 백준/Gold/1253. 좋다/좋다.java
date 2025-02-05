import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    /**
     * N개의 수 중에서 어떤 수가 다른 수 두 개의 합으로 나타낼 수 있다면 그 수를 “좋다(GOOD)”고 한다.
     *
     * N개의 수가 주어지면 그 중에서 좋은 수의 개수는 몇 개인지 출력하라.
     *
     * 수의 위치가 다르면 값이 같아도 다른 수이다.
     *
     * 첫째 줄에는 수의 개수 N(1 ≤ N ≤ 2,000), 두 번째 줄에는 i번째 수를 나타내는 Ai가 N개 주어진다. (|Ai| ≤ 1,000,000,000, Ai는 정수).
     *
     * 입력
     * 10
     * 1 2 3 4 5 6 7 8 9 10
     */
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long [] array = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            array[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(array);

        long choose;
        int start_index;
        int end_index;
        long sum;
        int answer = 0;

        for (int i=0; i<n; i++){
            choose = array[i];

            start_index = 0;
            end_index = n-1;

            sum = array[start_index] + array[end_index];
            while (start_index < end_index){
                if (sum == choose){
                    if (start_index != i && end_index != i) {
                        answer++;
                        break;
                    }
                    else if (start_index == i){
                        start_index ++;
                    }
                    else if (end_index == i){
                        end_index --;
                    }
                }
                else if (sum < choose){
                    start_index ++;
                }
                else if (sum > choose){
                    end_index --;
                }
                sum = array[start_index] + array[end_index];
            }
        }
        System.out.println(answer);
        br.close();
    }
}
