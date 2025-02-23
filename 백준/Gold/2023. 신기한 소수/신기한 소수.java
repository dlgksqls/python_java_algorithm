import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    static int n;

    // 맨 상위 숫자는 2, 3, 5, 7
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);

        br.close();
    }

    private static void dfs(int number, int digits) {
        if (digits == n){
            if (isPrime(number)){
                System.out.println(number);
            }
            return;
        }
        for(int i=1; i<10; i++){
            if (i%2==0){
                continue;
            }
            if (isPrime(number * 10 + i)){
                dfs(number * 10 + i, digits + 1);
            }
        }
    }

    private static boolean isPrime(int number) {
        for (int i=2; i<=number/2; i++){
            if (number%i == 0)
                return false;
        }
        return true;
    }
}
