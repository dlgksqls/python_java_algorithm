import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc ++){
            int n = sc.nextInt();
            LinkedList<Integer>list_a = new LinkedList<>();
            LinkedList<Integer>list_b = new LinkedList<>();

            for(int i=0; i<n; i++){
                list_a.add(sc.nextInt());
            }

            for(int i=0; i<n; i++){
                list_b.add(sc.nextInt());
            }

            char[] answer = new char[n+1];
            while (!list_a.isEmpty() && !list_b.isEmpty()) {
                int a = list_a.poll();
                list_b.removeIf(x -> x == a);
                answer[a] = 'A';

                if (!list_b.isEmpty()) {
                    int b = list_b.poll();
                    list_a.removeIf(x -> x == b);
                    answer[b] = 'B';
                }
            }

            for(int i=1; i<answer.length; i++){
                System.out.print(answer[i]);
            }
            System.out.println();
        }
    }
}
