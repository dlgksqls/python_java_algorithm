import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 정렬 -> 양 끝에 포인터 -> 작으면 오른쪽 포인터를, 크면 왼쪽 포인터를
public class Main {
    static int n;
    static int[] array;
    static int x;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        array = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        x = Integer.parseInt(br.readLine());

        Arrays.sort(array);

        int start = 0;
        int end = array.length-1;

        while(start < end){
            int sum = array[start] + array[end];
            if (sum == x) {
                answer ++;
                start ++;
                end --;
            }
            else if (sum < x){
                start ++;
            }
            else if (sum > x){
                end --;
            }
        }

        System.out.println(answer);
    }
}
