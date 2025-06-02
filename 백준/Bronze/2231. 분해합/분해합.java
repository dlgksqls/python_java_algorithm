import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<=n ;i++){
            int result = i;
            int num = i;
            while(num >= 10){
                result += num % 10;
                num /= 10;
            }
            result += num;
            if (n == result) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
    }
}
