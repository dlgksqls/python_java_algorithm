import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int ice_cream[] = new int[n+1];
        boolean input[][] = new boolean[n+1][n+1];
        int answer = 0;

        for (int i=1; i<=n; i++)
            ice_cream[i] = i;
        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            input[x][y] = true;
            input[y][x] = true;
        }

        for (int i=1; i<=n-2; i++){
            for (int j=i+1; j<=n-1; j++){
                for (int k=j+1; k<=n; k++){
                    if (!input[i][j] && !input[j][k] && !input[i][k]){
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
        br.close();
    }
}
