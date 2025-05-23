import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());
            LinkedList<String> input = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                input.add(st.nextToken());
            }

            n = Integer.parseInt(br.readLine());
            String[] order = br.readLine().split(" ");

            for (int i = 0; i < order.length; i++) {
                if (order[i].equals("I")) {
                    int end = Integer.parseInt(order[++i]);
                    int cnt = Integer.parseInt(order[++i]);

                    for (int j = 0; j < cnt; j++) {
                        input.add(end++, order[++i]);
                    }
                }
            }

            System.out.print("#" + tc + " ");
            for(int i=0; i<10; i++){
                System.out.print(input.get(i) + " ");
            }
            System.out.println();
        }
    }
}
