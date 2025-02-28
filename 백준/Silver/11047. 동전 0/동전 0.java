import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int k;
    static int[] array;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        array = new int[n];

        for (int i=0; i<n; i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        for (int i=n-1; i>=0; i--){
            if (k == 0){
                break;
            }
            if (array[i] > k){
                continue;
            }

            answer += k/array[i];
            k %= array[i];
        }
        System.out.println(answer);
    }
}
