import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int a;
        int b;

        for(int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            int result = a * b / gcd(a, b);
            System.out.println(result);
        }
    }

    private static int gcd(int a, int b) {
        if (a == 0){
            return b;
        }
        return gcd(b % a, a);
    }
}
