import java.util.*;
import java.io.*;
public class Main {
    static int n, k;
    static int answer;
    static Integer inputs[];
    static int input;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        inputs = new Integer[n];

        for (int i=0; i<n; i++){
            input = Integer.parseInt(br.readLine());
            inputs[i] = input;
        }

        Arrays.sort(inputs, Collections.reverseOrder());

        for (int num : inputs) {
            if (num == 0){
                break;
            }
            else {
                while (true){
                    if (k >= num){
                        k -= num;
                        answer ++;
                    }
                    else
                        break;
                }
            }
        }
        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}
