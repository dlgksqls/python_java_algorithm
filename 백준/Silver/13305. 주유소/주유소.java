import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        long city[] = new long[n];
        long road[] = new long[n-1];

        long answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<road.length; i++){
            road[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<city.length; i++){
            city[i] = Integer.parseInt(st.nextToken());
        }

        long min_road = city[0];

        for (int i=0; i<n-1; i++){
            if (road[i] < min_road){
                min_road = city[i];
            }
            answer += (min_road * road[i]);
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
