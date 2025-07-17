import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] words;
    static int answer = Integer.MIN_VALUE;
    static int init = (1 << ('a' - 'a')) | (1 << ('c' - 'a')) | (1 << ('i' - 'a')) | (1 << ('n' - 'a')) | (1 << ('t' - 'a'));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (k < 5){
            System.out.println(0);
            return;
        }

        words = new int[n];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            int mask = 0;
            for (char c : str.toCharArray()) {
                mask |= (1 << (c - 'a'));
            }
            words[i] = mask;
        }

        recursion(0, 0, init);

        System.out.println(answer);
        br.close();
    }

    private static void recursion(int idx, int depth, int mask) {
        if (depth == k - 5) {
            int count = 0;
            for (int word : words) {
                if ((word & mask) == word){
                    count ++;
                }
            }
            answer = Math.max(answer, count);
            return;
        }

        for(int i=idx; i<26; i++){
            if ((mask & (1 << i)) != 0 ) continue;
            recursion(i + 1, depth + 1, mask | (1 << i));
        }
    }
}