import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static double answer = 0;
    static ArrayList<double[]> array;
    static int n;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc ++){
            n = Integer.parseInt(br.readLine());
            array = new ArrayList<>();

            for(int i=0; i<n; i++){
                double[] p = new double[n];
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    p[j] = Double.parseDouble(st.nextToken()) * 0.01;
                }
                array.add(p);
            }

            answer = Double.MIN_VALUE;
            visited = new boolean[n];
            recursion(0, 1);

            System.out.println("#" + tc + " " + String.format("%.6f", answer * 100));
        }
        br.close();
    }

    private static void recursion(int idx, double result) {
        if (result <= answer) return;
        if (idx == n){
            answer = Math.max(answer, result);
            return;
        }

        for(int i=0; i<n; i++){
            if (!visited[i]){
                visited[i] = true;
                recursion(idx + 1, result * array.get(idx)[i]);
                visited[i] = false;
            }
        }
    }
}
