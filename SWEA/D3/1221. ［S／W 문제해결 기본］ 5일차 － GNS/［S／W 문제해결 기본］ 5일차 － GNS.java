import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc ++){

            HashMap<String, Integer> map = new HashMap<>();
            map.put("ZRO", 0);
            map.put("ONE", 1);
            map.put("TWO", 2);
            map.put("THR", 3);
            map.put("FOR", 4);
            map.put("FIV", 5);
            map.put("SIX", 6);
            map.put("SVN", 7);
            map.put("EGT", 8);
            map.put("NIN", 9);

            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingInt(x -> map.get(x)));
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<num; i++){
                queue.add(st.nextToken());
            }

            System.out.println("#" + tc);
            while (!queue.isEmpty()) {
                System.out.print(queue.poll() + " ");
            }
            System.out.println();
        }
    }
}
