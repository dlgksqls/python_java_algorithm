import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] op_visited;
    static ArrayList<Character> op_count;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Character> op = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            char opChar = 0;
            if (i == 0) opChar = '+';
            else if (i == 1) opChar = '-';
            else if (i == 2) opChar = '*';
            else opChar = '/';

            int count = Integer.parseInt(st.nextToken());
            for(int j=0; j<count; j++){
                op.add(opChar);
            }
        }

        op_count = new ArrayList<>();
        op_visited = new boolean[n-1];
        recursion(array, op);

        System.out.println(max);
        System.out.println(min);

        br.close();
    }

    private static void recursion(int[] array, ArrayList<Character> op) {

        if (op_count.size() == op.size()){
            int result = operator(array, op_count);

            max = Math.max(max, result);
            min = Math.min(min, result);

            return;
        }

        for(int i=0; i<op.size(); i++){
            if (!op_visited[i]){
                op_visited[i] = true;
                op_count.add(op.get(i));
                recursion(array, op);
                op_count.remove(op_count.size()-1);
                op_visited[i] = false;
            }
        }
    }

    private static int operator(int[] array, ArrayList<Character> op) {
        int result = array[0];
        for(int i=0; i<op.size(); i++){
            int num1 = array[i+1];
            char opChar = op.get(i);

            if (opChar == '+') result += num1;
            else if(opChar == '-') result -= num1;
            else if(opChar == '*') result *= num1;
            else if(opChar == '/'){
                if (result < 0) {
                    result *= -1;
                    result /= num1;
                    result *= -1;
                }
                else{
                    result /= num1;
                }
            }
        }

        return result;
    }
}
