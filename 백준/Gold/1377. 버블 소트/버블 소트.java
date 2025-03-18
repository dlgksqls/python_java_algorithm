import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Data[] array = new Data[n];

        for(int i=0; i<n; i++){
            array[i] = new Data(i, Integer.parseInt(br.readLine()));
        }

        Arrays.sort(array);

        int max = 0;
        for (int i=0; i<n; i++){
            if (max < array[i].index - i) max = array[i].index - i;
        }

        System.out.println(max+1);
    }

    private static class Data implements Comparable<Data>{
        int index;
        int value;

        public Data(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Data data) {
            return this.value - data.value;
        }
    }
}
