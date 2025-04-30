import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            int n = Integer.parseInt(br.readLine());
            int answer = 0;

            for(int i = -n; i <= n; i++){
                for(int j = -n; j <= n; j++){
                    if (Math.pow(i, 2) + Math.pow(j, 2) <= Math.pow(n, 2)){
                        answer ++;
                    }
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}
