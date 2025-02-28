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
            while (true){
                if (k < array[i]){
                    break;
                }
                k -= array[i];
                answer++;
            }
        }
        System.out.println(answer);
    }
}
