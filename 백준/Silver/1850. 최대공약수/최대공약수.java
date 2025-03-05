import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int answer = gcd(a, b);

        while (answer > 0){
            bw.write("1");
            answer --;
        }
        bw.flush();
        br.close();
    }

    private static int gcd(long a, long b) {
        if (a == 0){
            return (int)b;
        }
        return gcd(b % a, a);
    }
}
