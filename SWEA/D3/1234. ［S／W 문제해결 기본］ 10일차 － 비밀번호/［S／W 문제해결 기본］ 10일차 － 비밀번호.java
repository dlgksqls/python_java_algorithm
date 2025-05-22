import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int n = sc.nextInt();
            LinkedList<Character> list = new LinkedList<>();

            for (char c : sc.next().toCharArray()) {
                list.add(c);
            }

            int i=0;
            while(i < list.size()-1){
                if (list.get(i) != list.get(i+1)) i++;
                else {
                    list.remove(i);
                    list.remove(i);
                    if (i == 0) continue;
                    i --;
                }
            }

            System.out.print("#" + tc + " ");
            for (Character c : list) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}