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
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        array = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        if (k == 0) answer --;
        recursion(0, 0);
        System.out.println(answer);
        br.close();
    }

    private static void recursion(int idx, int sum) {
        if (idx == n){
            if (sum == k) {
                answer ++;
            }
            return;
        }

        recursion(idx + 1, sum + array[idx]);

        recursion(idx + 1, sum);
    }
}
