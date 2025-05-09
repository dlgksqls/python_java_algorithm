import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc ++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            array = new int[n+1];
            for(int i=1; i<=n; i++){
                array[i] = i;
            }

            System.out.print("#" + tc + " ");
            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int op = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (op == 0){
                    union(a, b);
                }
                else if (op == 1){
                    if (find(a) != find(b)) System.out.print(0);
                    else System.out.print(1);
                }
            }
            System.out.println();
        }
        br.close();
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            array[rootB] = rootA;
        }
    }

    private static int find(int x) {
        if (array[x] == x) return x;
        return array[x] = find(array[x]);
    }
}