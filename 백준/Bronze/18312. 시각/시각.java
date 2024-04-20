import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int answer = 0;

        for (int i=0; i<=n; i++){
            String i_str = Integer.toString(i);
            for (int j=0; j<60; j++){
                String j_str = Integer.toString(j);
                for (int l=0; l<60; l++){
                    String l_str = Integer.toString(l);
                    if (i < 10) {
                        i_str = "0" + i_str;
                    }
                    if (j < 10){
                        j_str = "0" + j_str;
                    }
                    if (l < 10){
                        l_str = "0" + l_str;
                    }

                    String number = i_str + j_str + l_str;

                    if (number.contains(Integer.toString(k)))
                        answer ++;
                }
            }
        }
        System.out.println(answer);
    }
}
