import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] array;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int find = Integer.parseInt(st.nextToken());
            binary_search(find, 0, n - 1);
        }

        br.close();
    }

    private static void binary_search(int find, int left, int right) {
        if (left > right) {
            System.out.println(0);
            return;
        }

        int mid = (left + right) / 2;

        if (array[mid] == find) {
            System.out.println(1);
        } else if (array[mid] > find) {
            binary_search(find, left, mid - 1);
        } else {
            binary_search(find, mid + 1, right);
        }
    }
}
