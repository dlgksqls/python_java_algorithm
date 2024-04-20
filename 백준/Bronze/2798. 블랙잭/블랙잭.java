import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int sum;
        int answer=0;

        Integer input[] = new Integer[n];

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input, Collections.reverseOrder());

        for (int i=0; i<n-2; i++){
            for (int j=i+1; j<n-1; j++){
                for (int k=j+1; k<n; k++){
                    sum = input[i] + input[j] + input[k];
                    if (sum == m) {
                        answer = sum;
                        System.out.println(answer);
                        return;
                    }
                    else if (answer < sum && m > sum){
                        answer = sum;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
