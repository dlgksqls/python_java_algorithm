import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] array = new int[w];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<w; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for(int i=1; i<w-1; i++){
            int leftMax = Integer.MIN_VALUE;
            int rightMax = Integer.MIN_VALUE;

            for(int j=0; j<i; j++){
                leftMax = Math.max(leftMax, array[j]);
            }

            for(int j=i; j<w; j++){
                rightMax = Math.max(rightMax, array[j]);
            }

            int minHeight = Math.min(leftMax, rightMax);
            if (array[i] < minHeight) {
                result += minHeight - array[i];
            }
        }

        System.out.println(result);
        br.close();
    }
}
