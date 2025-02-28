import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int left = 1;
    static int right = 0;
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, array[i]);
            right += array[i];
        }

        while (left <= right){
            int mid = (left + right) / 2;
            int count = 1;
            int sum = 0;

            for (int lecture : array) {
                if (sum + lecture > mid){
                    count ++;
                    sum = lecture;
                }
                else{
                    sum += lecture;
                }
            }
            if (count <= m){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        System.out.println(left);
    }
}
