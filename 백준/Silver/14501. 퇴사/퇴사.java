import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class interview{
        int t;
        int p;

        public interview(int t, int p) {
            this.t = t;
            this.p = p;
        }
    }

    static int n;
    static int answer = 0;
    static List<interview> array = new ArrayList<>();

    private static void recursion(int idx, int price) {
        if (idx >= n){
            answer = Math.max(answer, price);
            return;
        }

        // 상담을 한다면 (상담이 퇴사일을 넘지 않는 경우만)
        if (idx + array.get(idx).t <= n) {
            recursion(idx + array.get(idx).t, price + array.get(idx).p);
        }

        // 상담을 안한다면
        recursion(idx + 1, price);
    }

    // 모든 날에 상담을 받거나, 안받거나 모든 경우의 수를 확인해준다
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            array.add(new interview(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        recursion(0, 0);

        System.out.println(answer);

        br.close();
    }
}
