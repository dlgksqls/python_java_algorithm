import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    /**
     * 갑옷을 만드는 재료들은 각각 고유한 번호를 가지고 있다.
     * 갑옷은 두 개의 재료로 만드는데 두 재료의 고유한 번호를 합쳐서 M(1 ≤ M ≤ 10,000,000)이 되면 갑옷이 만들어 지게 된다.
     * 야철대장은 자신이 만들고 있는 재료를 가지고 갑옷을 몇 개나 만들 수 있는지 궁금해졌다.
     * 이러한 궁금증을 풀어 주기 위하여 N(1 ≤ N ≤ 15,000) 개의 재료와 M이 주어졌을 때 몇 개의 갑옷을 만들 수 있는지를 구하는 프로그램을 작성하시오.
     *
     * 첫째 줄에는 재료의 개수 N(1 ≤ N ≤ 15,000)이 주어진다. 그리고 두 번째 줄에는 갑옷을 만드는데 필요한 수 M(1 ≤ M ≤ 10,000,000) 주어진다.
     * 그리고 마지막으로 셋째 줄에는 N개의 재료들이 가진 고유한 번호들이 공백을 사이에 두고 주어진다. 고유한 번호는 100,000보다 작거나 같은 자연수이다.
     *
     * 입력
     * 6
     * 9
     * 2 7 4 1 5 3
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        int [] array = new int[n];
        int start_index = 0;
        int end_index = array.length-1;
        int answer = 0;
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        sum = array[start_index] + array[end_index];

        while (start_index < end_index){
            if (sum == m){
                answer ++;
                start_index ++;
                end_index --;
            }
            else if (sum > m){
                end_index --;
            }
            else if (sum < m){
                start_index ++;
            }
            sum = array[start_index] + array[end_index];
        }
        System.out.println(answer);
        br.close();
    }
}