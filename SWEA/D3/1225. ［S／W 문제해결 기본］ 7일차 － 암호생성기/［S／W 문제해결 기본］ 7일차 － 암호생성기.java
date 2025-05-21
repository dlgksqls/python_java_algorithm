import java.util.*;

public class Solution {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {
            int T = sc.nextInt();

            Queue<Integer> queue = new LinkedList<>();
            for(int i=0; i<8; i++){
                queue.add(sc.nextInt());
            }

            int count = 0;
            while(true){
                count ++;
                if (count == 6){
                    count = 1;
                }
                int poll = queue.poll() - count;
                if (poll <= 0) {
                    queue.add(0);
                    break;
                }
                queue.add(poll);
            }

            System.out.print("#" + tc + " ");
            while(!queue.isEmpty()){
                System.out.print(queue.poll() + " ");
            }
            System.out.println();
        }
    }
}
