import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static Integer answers[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        answers = new Integer[n];
        long answer = 0;

        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tip = Integer.parseInt(st.nextToken());
            answers[i] = tip;
        }
        Arrays.sort(answers, Collections.reverseOrder());

        for (int i=0; i<n; i++){
            if (answers[i] > i) {
                answer += answers[i] - i;
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
