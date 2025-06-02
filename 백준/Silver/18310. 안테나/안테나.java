import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] homes = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            homes[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(homes);

        System.out.println(homes[(n-1) / 2]);
        br.close();
    }
}
