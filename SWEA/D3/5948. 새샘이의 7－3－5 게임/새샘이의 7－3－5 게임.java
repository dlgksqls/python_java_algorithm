import java.util.*;

public class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            Integer[] array = new Integer[7];
            TreeSet<Integer> hashSet = new TreeSet<>(Collections.reverseOrder());

            for(int i=0; i<7; i++){
                array[i] = sc.nextInt();
            }

            Arrays.sort(array, Collections.reverseOrder());
            for(int i=0; i<5; i++){
                for(int j=i+1; j<6; j++){
                    for (int k=j+1; k<7; k++){
                        hashSet.add(array[i] + array[j] + array[k]);
                    }
                }
            }

            int count = 1;
            for (Integer i : hashSet) {
                if (count == 5)
                    System.out.println("#" + tc + " " + i);
                count ++;
            }
        }
    }
}
