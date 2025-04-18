import java.util.*;

public class Solution {

    static int max;
    static char[] ch_input;
    static HashSet<String> visited;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            ch_input = sc.next().toCharArray();
            int win = sc.nextInt();
            max = 0;
            visited = new HashSet<>();

            dfs(win, 0);

            System.out.println("#" + tc + " " + max);
        }
    }

    private static void dfs(int win, int depth) {
        if (depth == win){
            max = Math.max(max, Integer.parseInt(new String(ch_input)));
            return;
        }

        String check = new String(ch_input);
        if (visited.contains(check)) return;
        else visited.add(check);

        for(int i=0; i<ch_input.length-1; i++){
            for(int j=i+1; j<ch_input.length; j++){
                swap(i, j);
                dfs(win, depth+1);
                swap(i, j);
            }
        }
    }

    private static void swap(int a, int b) {
        char tmp = ch_input[a];
        ch_input[a] = ch_input[b];
        ch_input[b] = tmp;
    }
}
