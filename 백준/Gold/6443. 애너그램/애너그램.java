import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean[] visited;
    static char[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc ++){
            array = br.readLine().toCharArray();
            visited = new boolean[array.length];

            Arrays.sort(array);

            recursion(0, new StringBuilder());

        }
        br.close();
    }

    private static void recursion(int depth, StringBuilder sb) {
        if (depth == array.length){
            System.out.println(sb);
            return;
        }

        char prev = 0;
        for(int i=0; i<array.length; i++){
            if (!visited[i] && prev != array[i]){
                visited[i] = true;
                sb.append(array[i]);
                recursion(depth + 1, sb);
                visited[i] = false;
                sb.deleteCharAt(sb.length()-1);
                prev = array[i];
            }
        }
    }
}
