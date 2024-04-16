import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String input;
        input = br.readLine();

        int rCnt = 0;
        int bCnt = 0;
        char bf = '\0';

        for (int i = 0; i < n; i++) {
            char cur = input.charAt(i);
            if (cur != bf) {
                if (cur == 'B')
                    bCnt++;
                else
                    rCnt++;
            }
            bf = cur;
        }
        bw.write(String.valueOf(Math.min(bCnt, rCnt) + 1));

        br.close();
        bw.close();
    }
}
