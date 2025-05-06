import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc ++){
            int n = Integer.parseInt(br.readLine());
            int[] corridor = new int[201];
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                int from = (Math.min(start, end) + 1) / 2;
                int to = (Math.max(start, end) + 1) / 2;

                for(int j = from; j <= to; j++){
                    corridor[j] ++;
                }
            }

            int answer = 0;
            for(int i=0; i<=200; i++){
                answer = Math.max(answer, corridor[i]);
            }

            System.out.println("#" + tc + " " + answer);
        }
        br.close();
    }
}