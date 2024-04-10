import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = 0;
        int count = 0;

        int n = Integer.parseInt(br.readLine());

        Integer prices[] = new Integer[n+1];
        prices[0] = 0;

        for (int i=1; i<prices.length; i++){
            int input = Integer.parseInt(br.readLine());
            prices[i] = input;
        }

        Arrays.sort(prices, Collections.reverseOrder());

        for (int i=0; i<prices.length; i++){
            count ++;
            if (count % 3 == 0)
                continue;
            answer += prices[i];
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
