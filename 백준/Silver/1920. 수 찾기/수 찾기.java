import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            binary_search(Integer.parseInt(st.nextToken()), 0, n-1);
        }
        br.close();
    }

    private static void binary_search(int number, int start, int end) {

        if (start > end) {
            System.out.println(0);
            return;
        }

        int mid = (start + end) / 2;
        if (number == array[mid]){
            System.out.println(1);
            return;
        }
        if (number > array[mid]){
            binary_search(number, mid + 1, end);
        }
        else if (number < array[mid]){
            binary_search(number, start, mid - 1);
        }
    }
}
