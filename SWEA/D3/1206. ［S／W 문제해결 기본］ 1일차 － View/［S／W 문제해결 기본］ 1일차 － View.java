import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int tc = 1; tc <= 10; tc ++){
            int n = Integer.parseInt(br.readLine());
            int[] array = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                array[i] = Integer.parseInt(st.nextToken());
            }

            int answer = 0;
            for(int i=2; i<n-2; i++){
                int lMax = Math.max(array[i-1], array[i-2]);
                int rMax = Math.max(array[i+1], array[i+2]);

                int max = Math.max(lMax, rMax);

                if (array[i] - max <= 0) continue;
                answer += array[i] - max;
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}
