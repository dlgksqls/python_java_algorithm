import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] array;
    static int sum=0;
    static int answer=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        int start_index = 0;
        int end_index = n-1;

        Arrays.sort(array);
        sum = array[start_index] + array[end_index];

        while(start_index < end_index){
            if (sum == m){
                answer ++;
                start_index ++;
                end_index --;
            }
            else if (sum < m){
                start_index ++;
            }
            else if (sum > m){
                end_index --;
            }
            sum = array[start_index] + array[end_index];
        }

        System.out.println(answer);
        br.close();
    }
}
