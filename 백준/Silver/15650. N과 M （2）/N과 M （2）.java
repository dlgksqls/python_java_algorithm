import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static List<Integer> array;

    private static void recursion(int number) {
        if (number == m){
            for (Integer i : array) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i=1; i<=n; i++){
            if (array.contains(i)) continue;
            else if (array.size() == 0) {}
            else if (array.get(array.size()-1) > i) continue;

            array.add(i);
            recursion(number + 1);
            array.remove(array.size()-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new ArrayList<>();

        recursion(0);

        br.close();
    }
}
