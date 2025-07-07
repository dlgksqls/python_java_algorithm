import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        visited = new boolean[input.length()];
        recursion(input, 0, input.length()-1);
    }

    private static void recursion(String input, int start, int end) {
        if(start > end) return;

        char minChar = 'Z' + 1;
        int minIdx = -1;

        for(int i=start; i<=end; i++){
            if (!visited[i] && input.charAt(i) < minChar){
                minChar = input.charAt(i);
                minIdx = i;
            }
        }

        visited[minIdx] = true;

        for(int i=0; i<input.length(); i++){
            if (visited[i]){
                System.out.print(input.charAt(i));
            }
        }
        System.out.println();

        recursion(input, minIdx + 1, end);
        recursion(input, start, minIdx - 1);
    }
}