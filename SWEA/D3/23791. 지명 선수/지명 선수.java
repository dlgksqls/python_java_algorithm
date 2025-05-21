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
            int count = 0;
            while(count < n){
                while(!list_a.isEmpty()){
                    int select = list_a.poll();
                    if (answer[select] == 0){
                        answer[select] = 'A';
                        count ++;
                        break;
                    }
                }
                while (!list_b.isEmpty()){
                    int select = list_b.poll();
                    if (answer[select] == 0){
                        answer[select] = 'B';
                        count ++;
                        break;
                    }
                }
            }

            for(int i=1; i<answer.length; i++){
                System.out.print(answer[i]);
            }
            System.out.println();
        }
    }
}
