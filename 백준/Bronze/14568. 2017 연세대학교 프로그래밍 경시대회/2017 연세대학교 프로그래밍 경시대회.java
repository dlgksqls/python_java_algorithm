import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int a=1; a<=n; a++){
            for (int b=1; b<=n; b++){
                for (int c=1; c<=n; c++){
                    if (a + b + c == n){
                        if (a >= b + 2){
                            if (c % 2 == 0) answer ++;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
        br.close();
    }
}
