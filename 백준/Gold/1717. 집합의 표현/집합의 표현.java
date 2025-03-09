import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[n+1];

        for(int i=0; i<=n; i++){
            array[i] = i;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int check = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (check == 0){
                union(a, b);
                continue;
            }
            if (checkSame(a, b)) {
                System.out.println("YES");
                continue;
            }
            System.out.println("NO");
        }
    }

    private static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b){
            return true;
        }
        return false;
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b){
            array[b] = a;
        }
    }

    private static int find(int a) {
        if (a == array[a]){
            return a;
        }
        else {
            return array[a] = find(array[a]);
        }
    }
}
