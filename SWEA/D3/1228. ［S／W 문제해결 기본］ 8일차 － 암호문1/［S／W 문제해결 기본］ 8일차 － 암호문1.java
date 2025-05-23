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
            String[] order = br.readLine().split("I");

            for (String s : order) {
                if (s.equals("")) continue;

                String[] split = s.split(" ");
                int end = Integer.parseInt(split[1]);
                int length = Integer.parseInt(split[2]);

                ArrayList<String> str = new ArrayList<>();
                for(int i=0; i<length; i++){
                    str.add(split[i+3]);
                }

                input.addAll(end, str);
            }

            System.out.print("#" + tc + " ");
            for(int i=0; i<10; i++){
                System.out.print(input.get(i) + " ");
            }
            System.out.println();
        }
    }
}
