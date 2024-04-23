import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int tired = 0;
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;

        for (int i=0; i<24; i++){
            if (i == 0 && tired > m)
                break;
            if (tired + a > m){
                tired -= c;
                if (tired < 0)
                    tired = 0;
            }
            else {
                answer += b;
                tired += a;
            }
        }
        System.out.println(answer);
        br.close();
    }
}
