import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static String answer;
    static boolean flag = false;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        recursion(sb, 0);

        System.out.println(answer);
        br.close();
    }

    private static void recursion(StringBuilder sb, int depth) {
        if (flag) return;
        if (depth == n){
            answer = sb.toString();
            flag = true;
            return;
        }

        for(int i=1; i<=3; i++){
            sb.append(i);

            if (check(sb)) {
                recursion(sb, depth + 1);
            }

            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private static boolean check(StringBuilder sb) {
        int len = sb.length();
        for(int i=1; i<=len/2; i++){
            String prev = sb.substring(len-2*i, len-i);
            String curr = sb.substring(len-i);
            if (prev.equals(curr)) return false;
        }

        return true;
    }
}
