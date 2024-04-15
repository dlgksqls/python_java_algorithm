import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long max = 0;
        Long input[] = new Long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++)
            input[i] = Long.parseLong(st.nextToken());

        Arrays.sort(input);

        if (n%2==0){
            for (int i=0; i<(n/2)+1;i++){
                long sum = input[i] + input[n-1-i];
                max = Math.max(max, sum);
            }
        }
        else{
            max = input[n-1];
            for (int i=0; i<(n/2)+1;i++){
                long sum = input[i] + input[n-2-i];
                max = Math.max(max, sum);
            }
        }

        bw.write(String.valueOf(max));

        br.close();
        bw.close();
    }
}
