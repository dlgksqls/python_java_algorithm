import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        if (n == 1 || n == 2){
            System.out.println(n);
            return;
        }

        int maxLength = Integer.MIN_VALUE;

        for(int i=0; i<n-2; i++){
            int len = 2;
            for(int j=i+2; j<n; j++){
                if (array[i] + array[i+1] > array[j]){
                    len ++;
                }
                else break;
            }
            maxLength = Math.max(maxLength, len);
        }

        System.out.println(maxLength);
        br.close();
    }
}
