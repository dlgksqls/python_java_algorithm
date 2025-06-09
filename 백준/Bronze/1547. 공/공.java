import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean[] array = new boolean[3];
        array[0] = true;

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken()) - 1;
            int second = Integer.parseInt(st.nextToken()) - 1;

            if (array[first]) {
                array[first] = false;
                array[second] = true;
            }
            else if (array[second]){
                array[second] = false;
                array[first] = true;
            }
        }

        for(int i=0; i<3; i++){
            if (array[i]) {
                System.out.println(i + 1);
                br.close();
                return;
            }
        }
        System.out.println(-1);

        br.close();
    }
}
