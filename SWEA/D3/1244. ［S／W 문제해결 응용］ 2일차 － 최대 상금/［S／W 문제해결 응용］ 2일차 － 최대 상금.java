import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int max;
    static char[] input;
    static HashSet<String> visited;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            input = st.nextToken().toCharArray();
            int n = Integer.parseInt(st.nextToken());
            visited = new HashSet<>();
            max = Integer.MIN_VALUE;

            recursion(0, n);

            System.out.println("#" + tc + " " + max);
        }
    }

    private static void recursion(int idx, int n) {

        if (idx == n){
            max = Math.max(max, Integer.parseInt(new String(input)));
            return;
        }

        String check = new String(input);
        if (visited.contains(check)) return;
        else visited.add(check);

        for(int i=0; i<input.length-1; i++){
            for(int j=i+1; j< input.length; j++){
                swap(i, j);
                recursion(idx + 1, n);
                swap(i, j);
            }
        }
    }

    private static void swap(int i, int j) {
        char tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }
}
