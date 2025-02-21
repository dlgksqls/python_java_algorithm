import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Number[] array = new Number[n];

        for (int i=0; i<n; i++){
            array[i] = new Number(i, Integer.parseInt(br.readLine()));
        }

        Arrays.sort(array);
        int max = 0;

        for (int i=0; i<n; i++){
            if (max < array[i].index - i) {
                max = array[i].index - i;
            }
        }
        System.out.println(max + 1);
    }

    static class Number implements Comparable<Number>{
        int index;
        int value;

        public Number(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Number o) { // value 기준 오름차순 정렬
            return value - o.value;
        }
    }
}
