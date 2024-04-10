import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] times = new int[n];

        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(inputs[i]);
        }

        Arrays.sort(times);

        int sum = 0;
        int total = 0;
        for (int time : times) {
            sum += time;
            total += sum;
        }

        bw.write(String.valueOf(total));

        br.close();
        bw.close();
    }
}
