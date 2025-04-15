import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 정렬 -> 양 끝에 포인터 -> 작으면 오른쪽 포인터를, 크면 왼쪽 포인터를
public class Main {

    static int n;
    static int[] array;
    static int num;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        num = Integer.parseInt(br.readLine());

        Arrays.sort(array);
        int start = 0;
        int end = array.length - 1;

        while(start < end){
            if (array[start] + array[end] < num) start ++;
            else if (array[start] + array[end] > num) end --;
            else if (array[start] + array[end] == num) {
                answer ++;
                end --;
            }
        }

        System.out.println(answer);
    }
}
