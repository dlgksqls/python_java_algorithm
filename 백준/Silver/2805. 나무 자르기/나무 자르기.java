import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static long m;
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());

        array = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        int start = 1;
        int end = Arrays.stream(array).max().getAsInt();

        while(start <= end){
            int mid = (start + end) / 2;

            // 얼마나 나무를 채취했나?
            long wood = 0;

            for (int tree : array) {
                if (tree >= mid){
                    wood += tree - mid;
                }
            }

            // 채취한 나무가 업인가 다운인가?
            if (wood >= m) start = mid + 1; // 최소 만족하면 더 줄여보기
            else end = mid - 1;
        }

        System.out.println(end);
    }
}
