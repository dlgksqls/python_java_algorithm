import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        int tmp;
        String b = "";
        
        for (int i=0; i<a.length();i++){
            tmp = a.charAt(i);
            if (tmp >= 65 && tmp <= 90){
                b += (char)(tmp + 32);
            }
            else{
                b += (char)(tmp - 32);
            }
        }
        System.out.println(b);
    }
}