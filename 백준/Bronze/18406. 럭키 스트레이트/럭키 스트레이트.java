import java.util.Scanner;

public class Main {
    static char[] n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.next().toCharArray();
        int len = n.length;

        int sum1 = 0;
        int sum2 = 0;

        for(int i=0; i<len/2; i++){
            sum1 += n[i] - '0';
        }
        for(int i=len/2; i<n.length; i++){
            sum2 += n[i] - '0';
        }

        if (sum1 == sum2)
            System.out.println("LUCKY");
        else
            System.out.println("READY");
    }
}
