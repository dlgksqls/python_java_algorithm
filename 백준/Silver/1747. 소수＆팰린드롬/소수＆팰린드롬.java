import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int size = 10000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int [] array = new int[size];

        for (int i = 2; i< size; i++){
            array[i] = i;
        }

        for (int i=2; i<=Math.sqrt(array.length); i++){
            if (array[i] == 0){
                continue;
            }
            for (int j = i+i; j< size; j += i){
                array[j] = 0;
            }
        }

        for (int i = n; i< size; i++) {
            if (array[i] != 0) {
                char temp[] = String.valueOf(array[i]).toCharArray();
                int s = 0;
                int e = temp.length - 1;
                while (s < e) {
                    if (temp[s] != temp[e]) {
                        break;
                    }
                    s++;
                    e--;
                }
                if (s >= e) {
                    System.out.println(array[i]);
                    break;
                }
            }
        }
    }
}
