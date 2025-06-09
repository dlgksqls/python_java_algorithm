import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int jun;
    static int jun_count = 0;
    static int seong;
    static int seong_count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        jun = seong = Integer.parseInt(br.readLine());
        int last = 0;

        st = new StringTokenizer(br.readLine());
        int down = 0;
        int up = 0;
        int prev = 0;
        for(int i=0; i<14; i++){
            int now = Integer.parseInt(st.nextToken());
            if (jun >= now) {
                jun_count += jun / now;
                jun -= jun_count * now;
            }

            if (now > prev) {
                down = 0;
                up ++;
            }
            else if (now < prev) {
                up = 0;
                down ++;
            }

            if (up == 3){
                seong_count += seong / now;
                seong -= seong_count * now;
            }
            else if (down == 3){
                seong += seong_count * now;
                seong_count = 0;
            }

            last = now;
        }

        if (jun + jun_count * last > seong + seong_count * last) System.out.println("BNP");
        else if (jun + jun_count * last < seong + seong_count * last) System.out.println("TIMING");
        else System.out.println("SAMESAME");
        br.close();
    }
}
