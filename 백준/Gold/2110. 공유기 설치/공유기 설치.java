import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        int start = 1;
        int end = array[n-1];

        while(start <= end){
            int mid = (start + end) / 2;
            int pre_pos = 0;
            int cnt = 1;

            for(int i=1; i<n; i++){
                if (array[i] - array[pre_pos] >= mid){
                    pre_pos = i;
                    cnt ++;
                }
            }

            if (cnt < c){
                end = mid - 1;
                continue;
            }
            start = mid + 1;
        }

        System.out.println(end);
        br.close();
    }
}