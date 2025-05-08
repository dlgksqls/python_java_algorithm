import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc ++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            char[][] array = new char[n][m];

            for(int i=0; i<n; i++) {
                String input = br.readLine();
                array[i] = input.toCharArray();
            }

            int answer = Integer.MAX_VALUE;

            for(int wEnd = 0; wEnd < n - 2; wEnd ++){
                for(int bEnd = wEnd + 1; bEnd < n - 1; bEnd ++){
                    int count = 0;

                    // 흰색
                    for(int i = 0; i <= wEnd; i ++){
                        for(int j = 0; j < m; j ++){
                            if (array[i][j] != 'W') count ++;
                        }
                    }

                    // 파란색
                    for(int i = wEnd + 1; i <= bEnd; i++){
                        for(int j = 0; j < m; j ++){
                            if (array[i][j] != 'B') count ++;
                        }
                    }

                    // 빨간색
                    for(int i = bEnd + 1; i < n; i++){
                        for(int j = 0; j < m; j ++){
                            if (array[i][j] != 'R') count ++;
                        }
                    }
                    answer = Math.min(answer, count);
                }
            }
            System.out.println("#" + tc + " " + answer);
        }
        br.close();
    }
}
