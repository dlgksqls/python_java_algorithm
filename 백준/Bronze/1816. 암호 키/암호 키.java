import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            long input = Long.parseLong(br.readLine());
            for(int j=2; j<=1000000; j++){
                if (input % j == 0){
                    System.out.println("NO");
                    break;
                }
                if (j == 1000000){
                    System.out.println("YES");
                }
            }
        }
    }
}
