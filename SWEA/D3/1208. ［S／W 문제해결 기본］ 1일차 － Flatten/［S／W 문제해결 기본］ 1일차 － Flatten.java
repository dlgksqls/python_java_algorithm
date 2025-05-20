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

            int max = 0;
            int min = 0;

            for(int i=0; i<T; i++){
                max = Arrays.stream(array).max().getAsInt();
                min = Arrays.stream(array).min().getAsInt();

                boolean maxFlag = false;
                boolean minFlag = false;
                for(int j=0; j<100; j++){
                    if (array[j] == max && !maxFlag){
                        array[j] --;
                        maxFlag = true;
                    }
                    if (array[j] == min && !minFlag){
                        array[j] ++;
                        minFlag = true;
                    }

                    if (maxFlag && minFlag) break;
                }
            }

            max = Arrays.stream(array).max().getAsInt();
            min = Arrays.stream(array).min().getAsInt();
            System.out.println("#" + tc + " " + (max - min));
        }
    }
}
