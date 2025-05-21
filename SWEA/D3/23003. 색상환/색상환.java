import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("red", 0);
        hashMap.put("orange", 1);
        hashMap.put("yellow", 2);
        hashMap.put("green", 3);
        hashMap.put("blue", 4);
        hashMap.put("purple", 5);

        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            String c1 = sc.next();
            String c2 = sc.next();

            int idx1 = hashMap.get(c1);
            int idx2 = hashMap.get(c2);

            if (c1.equals(c2)) System.out.println("E");
            else if((idx1 + 1) % 6 == idx2 || (idx1 + 5) % 6 == idx2) System.out.println("A");
            else if((idx1 + 3) % 6 == idx2) System.out.println("C");
            else System.out.println("X");
        }
    }
}
