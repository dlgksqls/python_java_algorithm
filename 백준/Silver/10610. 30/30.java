import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String n = br.readLine();
        Integer input[] = new Integer[n.length()];
        int sum = 0;

        for (int i = 0; i < n.length(); i++) {
            input[i] = n.charAt(i) - '0';
            sum += input[i];
        }

        Arrays.sort(input, Collections.reverseOrder());

        if ((sum % 3 == 0)&&(input[input.length-1]==0)) {
            for (int num : input){
                bw.write(String.valueOf(num));
            }
        } else {
            System.out.println(-1);
        }
        br.close();
        bw.close();
    }
}