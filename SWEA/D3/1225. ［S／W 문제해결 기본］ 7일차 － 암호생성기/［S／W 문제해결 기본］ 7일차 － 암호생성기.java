import java.util.*;

public class Solution {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {
            int n = sc.nextInt();

            ArrayList<Integer> arrayList = new ArrayList<>();
            for(int i=0; i<8; i++){
                arrayList.add(sc.nextInt());
            }

            int count = 1;
            while(true){
                if (count > 5) count = 1;
                int pick = arrayList.get(0) - count;
                count ++;
                arrayList.remove(0);
                if (pick <=  0){
                    arrayList.add(0);
                    break;
                }
                arrayList.add(pick);
            }

            System.out.print("#" + tc + " ");
            arrayList.stream().forEach(number -> System.out.print(number + " "));
            System.out.println();
        }
    }
}
