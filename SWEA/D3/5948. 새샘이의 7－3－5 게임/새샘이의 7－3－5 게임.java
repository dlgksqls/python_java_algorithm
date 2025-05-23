import java.util.*;

public class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            Integer[] array = new Integer[7];
            TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());

            for(int i=0; i<7; i++){
                array[i] = sc.nextInt();
            }
            
            Arrays.sort(array, Collections.reverseOrder());
            
            for(int i=0; i<5; i++){
                for (int j=i+1; j<6; j++){
                    for(int k=j+1; k<7; k++){
                        treeSet.add(array[i] + array[j] + array[k]);
                    }
                }
            }
            
            int answer = 0;
            for(int i=0; i<5; i++){
                answer = treeSet.pollFirst();
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}
