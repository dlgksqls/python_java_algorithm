import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static int answers[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        int max = 0;
        answers = new int[n];

        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            answers[i] = w;
        }
        Arrays.sort(answers);

        for (int i=0; i<n; i++){
            max = Math.max(max, answers[i] * (n - i));
        }
        bw.write(String.valueOf(max));
        
        bw.close();
        br.close();
    }
}
