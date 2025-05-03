import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int answer;
    static int[] array;
    static int b;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc ++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            answer = Integer.MAX_VALUE;

            array = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                array[i] = Integer.parseInt(st.nextToken());
            }

            recursion(0, 0);

            System.out.println("#" + tc + " " + (answer - b));
        }
    }

    private static void recursion(int idx, int sum) {
        if (sum >= b){
            answer = Math.min(answer, sum);
            return;
        }
        if (idx == n){
            return;
        }

        recursion(idx + 1, sum + array[idx]);

        recursion(idx + 1, sum);
    }
}
