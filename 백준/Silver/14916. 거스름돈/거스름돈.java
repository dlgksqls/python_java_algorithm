import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = 0;

        int n = Integer.parseInt(br.readLine());

        if (n % 5 == 0)
            answer = n / 5;
        else{
            while (n!=0){
                if (n >= 10) {
                    n -= 5;
                    answer += 1;
                }
                else if (n % 2 == 0){
                    answer += n / 2;
                    n %= 2;
                }
                else if (n >= 5){
                    n -= 5;
                    answer += 1;
                }
                else if (n == 3 || n == 1) {
                    answer = -1;
                    break;
                }
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
