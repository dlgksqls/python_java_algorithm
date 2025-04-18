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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        array = new int[n+1];

        for(int i=1; i<=n; i++){
            array[i] = i;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (x == 0){
                union(a, b);
            }
            else if (x == 1){
                if (find(a) == find(b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }

        br.close();
    }

    private static int find(int a) {
        if (array[a] == a) return a;
        else {
            array[a] = find(array[a]);
            return find(array[a]);
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        array[b] = a;
    }
}
