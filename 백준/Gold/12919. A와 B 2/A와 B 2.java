import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        recursion(s, t);

        System.out.println(flag ? 1 : 0);
        br.close();
    }

    private static void recursion(String s, String t) {
        if (flag) return;
        if (t.length() == s.length()){
            if (t.equals(s)){
                flag = true;
            }
            return;
        }

        if(t.charAt(t.length()-1) == 'A') {
            recursion(s, t.substring(0, t.length() - 1));
        }
        if (t.charAt(0) == 'B'){
            String reverse = new StringBuilder(t).reverse().toString();
            recursion(s, reverse.substring(0, reverse.length()-1));
        }
    }
}
