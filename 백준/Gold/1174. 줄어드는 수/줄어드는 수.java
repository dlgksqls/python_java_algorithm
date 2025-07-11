import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class Main {
    static int n;
    static int answer;
    static ArrayList<Long> list = new ArrayList<>();
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for(int i=0; i<=9; i++) {
            recursion(i, i);
        }

        Collections.sort(list);

        if (list.size() < n){
            System.out.println(-1);
        }
        else{
            System.out.println(list.get(n - 1));
        }

        br.close();
    }

    private static void recursion(long current, int last) {
        list.add(current);

        for(int i=0; i<last; i++){
            recursion(current * 10 + i, i);
        }
    }
}
