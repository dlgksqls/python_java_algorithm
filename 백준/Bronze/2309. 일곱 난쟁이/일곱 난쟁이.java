import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static ArrayList<Integer> arrayList;
    static int[] result;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] array = new int[9];
        arrayList = new ArrayList<>();
        for(int i=0; i<9; i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        result = new int[7];
        recursion(0, array);

        Arrays.sort(result);

        for (int i : result) {
            System.out.println(i);
        }

        br.close();
    }

    private static void recursion(int idx, int[] array) {
        if (flag) return;
        if (arrayList.size() == 7){
            int sum = 0;
            for (Integer i : arrayList) {
                sum += i;
            }

            if (sum == 100){
                for(int i=0; i<7; i++){
                    result[i] = arrayList.get(i);
                }
                flag =  true;
                return;
            }
        }

        for(int i=idx; i<array.length; i++) {
            arrayList.add(array[i]);
            recursion(i + 1, array);
            arrayList.remove(arrayList.size() - 1);
        }
    }
}
