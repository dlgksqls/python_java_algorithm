import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] array;
    static boolean[] op_visited;
    static ArrayList<Character> op;
    static ArrayList<Character> op_count;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        array = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        op = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            char opChar;
            if (i == 0) opChar = '+';
            else if (i == 1) opChar = '-';
            else if (i == 2) opChar = '*';
            else opChar = '/';

            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                op.add(opChar);
            }
        }

        op_visited = new boolean[n - 1];
        op_count = new ArrayList<>();
        recursion();

        System.out.println(max);
        System.out.println(min);

        br.close();
    }

    private static void recursion() {
        if (op_count.size() == op.size()) {
            int result = operator(op_count);

            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < op.size(); i++) {
            if (!op_visited[i]) {
                op_visited[i] = true;
                op_count.add(op.get(i));
                recursion();
                op_visited[i] = false;
                op_count.remove(op_count.size() - 1);
            }
        }
    }

    private static int operator(ArrayList<Character> opCount) {
        int result = array[0];

        for (int i = 0; i < opCount.size(); i++) {
            int num = array[i + 1];
            char opChar = opCount.get(i);

            if (opChar == '+') result += num;
            else if (opChar == '-') result -= num;
            else if (opChar == '*') result *= num;
            else if (opChar == '/') {
                if (result < 0) {
                    result *= -1;
                    result /= num;
                    result *= -1;
                } else {
                    result /= num;
                }
            }
        }
        return result;
    }
}
