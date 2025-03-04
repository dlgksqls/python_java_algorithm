import java.io.*;
import java.util.*;

public class Main {
    static int m;
    static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int[] array = new int[n+1];
        for(int i=2; i<=n; i++){
            array[i] = i;
        }

        for (int i=2; i<=Math.sqrt(n); i++){
            if (array[i] == 0){
                continue;
            }
            for (int j=i+i; j<=n; j += i){
                array[j] = 0;
            }
        }
        for (int i=m; i<=n; i++){
            if (array[i] != 0){
                System.out.println(array[i]);
            }
        }

        br.close();
    }
}
