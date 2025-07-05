import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        recursion(input, 0);
        System.out.println(min + " " + max);
        br.close();
    }

    private static void recursion(String input, int cnt) {
        if (input.length() == 1){
            min = Math.min(min, cnt + count(input));
            max = Math.max(max, cnt + count(input));
            return;
        }

        if (input.length() == 2) {
            recursion(Integer.toString(input.charAt(0) - '0' + input.charAt(1) - '0'), cnt + count(input));
        }
        else {
            for(int i=1; i<input.length()-1; i++){
                for(int j=i+1; j<input.length(); j++){
                    int first = Integer.parseInt(input.substring(0, i));
                    int second = Integer.parseInt(input.substring(i, j));
                    int third = Integer.parseInt(input.substring(j, input.length()));

                    recursion(Integer.toString(first + second + third), cnt + count(input));
                }
            }
        }
    }

    private static int count(String input) {
        int count = 0;
        for(int i=0; i<input.length(); i++){
            if ((int)(input.charAt(i)) % 2 == 1){
                count ++;
            }
        }

        return count;
    }
}
