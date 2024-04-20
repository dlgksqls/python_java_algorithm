import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input[] = new int[6];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<6; i++)
            input[i] = Integer.parseInt(st.nextToken());

        for (int x=-999; x<=999; x++){
            for (int y=-999; y<=999; y++){
                if (input[0] * x + input[1] * y == input[2]) {
                    if (input[3] * x + input[4] * y == input[5]){
                        System.out.println(x + " " + y);
                        break;
                    }
                }
            }
        }
    }
}
