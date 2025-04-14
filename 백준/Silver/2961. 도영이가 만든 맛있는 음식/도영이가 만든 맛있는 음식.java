import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class ingre{
        int s;
        int b;

        public ingre(int s, int b) {
            this.s = s;
            this.b = b;
        }
    }
    static int n;
    static int answer = Integer.MAX_VALUE;
    static List<ingre> array;

    private static void recursion(int idx, int sin, int ssn, int use) {

        if (idx == n){
            if (use == 0) return; // 아무 재료도 사용하지 않았다면
            int result = Math.abs(sin - ssn);
            answer = Math.min(answer, result);
            return;
        }

        recursion(idx + 1, sin * array.get(idx).s, ssn + array.get(idx).b, use + 1); // 재료 사용 한 경우

        recursion(idx + 1, sin, ssn, use); // 사용하지 않은 경우
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new ArrayList<>();

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            array.add(new ingre(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        recursion(0, 1, 0, 0);

        System.out.println(answer);

        br.close();
    }
}
