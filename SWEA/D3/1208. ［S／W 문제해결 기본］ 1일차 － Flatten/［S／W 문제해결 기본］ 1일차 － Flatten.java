import java.util.*;

public class Solution {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {
            int T;
            T=sc.nextInt();
            
            int[] array = new int[100];

            for(int i=0; i<100; i++){
                array[i] = sc.nextInt();
            }

            int min;
            int max;

            for(int i=0; i<T; i++){
                min = Arrays.stream(array).min().getAsInt();
                max = Arrays.stream(array).max().getAsInt();

                int min_idx = -1;
                int max_idx = -1;

                for(int j=0; j<100; j++){
                    if (array[j] == min) min_idx = j;
                    if (array[j] == max) max_idx = j;

                    if (min_idx != -1 && max_idx != -1){
                        array[min_idx] += 1;
                        array[max_idx] -= 1;
                        break;
                    }
                }
            }
            min = Arrays.stream(array).min().getAsInt();
            max = Arrays.stream(array).max().getAsInt();
            System.out.println("#" + tc + " " + (max - min));
        }
    }
}
