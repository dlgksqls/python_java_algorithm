import java.io.IOException;
import java.util.Scanner;
public class Main {
    static int n;
    static int m;
    static int[][] array;
    static int[] check;
    static int[] final_array;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        array = new int[n+1][n+1];
        check = new int[n+1];
        final_array = new int[m+1];

        for (int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                array[i][j] = sc.nextInt();
            }
        }

        for (int i=1; i<=m; i++){
            final_array[i] = sc.nextInt();
        }

        for (int i=1; i<=n; i++){
            check[i] = i;
        }

        for (int i=1; i<=n; i++){
            for (int j=1; j<=n; j++){
                if (array[i][j] == 1){
                    union(i, j);
                }
            }
        }

        int index = find(final_array[1]);
        for (int i=2; i<final_array.length; i++){
            if (index != find(final_array[i])){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b){
            check[b] = a;
        }
    }

    private static int find(int a) {
        if (a == check[a]){
            return a;
        }

        return check[a] = find(check[a]);
    }
}
