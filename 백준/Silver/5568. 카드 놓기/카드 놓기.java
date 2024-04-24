import java.util.*;
import java.io.*;
public class Main {
    static int n, k;
    static int answer;
    static HashSet<String> hashSet = new HashSet<>();
    static boolean visited[];
    static String input[];

    public static void dfs(int depth, String num){
        if (depth == k) {
            hashSet.add(num);
        }
        else{
            for (int i=0; i<n; i++){
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(depth + 1, num + input[i]);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        input = new String[n];
        visited = new boolean[n];

        for (int i=0; i<n; i++){
            input[i] = br.readLine();
        }


        dfs(0, "");
        System.out.println(hashSet.size());

        br.close();

    }
}
