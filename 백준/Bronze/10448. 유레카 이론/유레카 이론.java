import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        int[] array = new int[45];
        for(int i=1; i<45; i++){
            array[i] = i * (i + 1) / 2;
        }

        for(int i=0; i<k; i++){
            boolean flag = false;
            int num = Integer.parseInt(br.readLine());

            for(int j=1; j<45; j++) {
                if (flag){
                    break;
                }
                else {
                    for (int l = 1; l < 45; l++) {
                        for (int m = 1; m < 45; m++) {
                            int sum = array[j] + array[l] + array[m];
                            if (num == sum) {
                                flag = true;
                            }
                        }
                    }
                }
            }

            if (flag) System.out.println(1);
            else System.out.println(0);
        }
        br.close();
    }
}
