import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        long n = Integer.parseInt(st.nextToken());

        long[] lines = new long[k];
        for(int i=0; i<k; i++){
            lines[i] = Long.parseLong(br.readLine());
        }

        long start = 1;
        long end = Arrays.stream(lines).max().getAsLong();

        while(start <= end){
            long mid = (start + end) / 2;
            long count = 0;

            for (long line : lines) {
                if (line >= mid){
                    count += line / mid;
                }
            }

            if (count >= n) start = mid + 1;
            else end = mid - 1;
        }

        System.out.println(end);
        br.close();
    }
}
