import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        double answer = 0;

        Double input[] = new Double[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            input[i] = Double.parseDouble(st.nextToken());
        }

        Arrays.sort(input, Collections.reverseOrder());

        for (int i=0; i<n; i++){
            if (i == 0){
                answer += input[i];
            }
            else{
                answer += input[i] / 2;
            }
        }

        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}
