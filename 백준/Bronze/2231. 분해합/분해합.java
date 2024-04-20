import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i=1; i<n; i++){
            int sum = 0;
            int number = i;

            while (number != 0){
                sum += number % 10;
                number = number / 10;
            }

            if (sum + i == n){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
