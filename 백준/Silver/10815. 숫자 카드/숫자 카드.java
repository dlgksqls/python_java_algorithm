import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] array1;
    static int[] array2;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        array1 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            array1[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        array2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            array2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array1);

        for (int number : array2) {
            int start = 0;
            int end = n-1;
            boolean flag = false;

            while(start <= end){
                int mid = (start + end) / 2;

                if (array1[mid] == number){
                    flag = true;
                    break;
                }
                else if (array1[mid] > number){
                    end = mid - 1;
                }
                else if (array1[mid] < number){
                    start = mid + 1;
                }
            }

            if (flag) System.out.print(1 + " ");
            else System.out.print(0 + " ");
        }

        br.close();
    }
}
