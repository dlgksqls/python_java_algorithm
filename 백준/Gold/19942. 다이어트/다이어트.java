import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class ingre{
        int dan;
        int ji;
        int tan;
        int bi;
        int price;

        public ingre(int dan, int ji, int tan, int bi, int price) {
            this.dan = dan;
            this.ji = ji;
            this.tan = tan;
            this.bi = bi;
            this.price = price;
        }
    }

    static int n;
    static int mp, mf, ms, mv;
    static int answer = Integer.MAX_VALUE;
    static List<ingre> array = new ArrayList<>();
    static List<Integer> answer_used = new ArrayList<>();
    static List<Integer> used = new ArrayList<>();

    private static void recursion(int idx, int d, int j, int t, int b, int p) {

        if (d >= mp && j >= mf && t >= ms && b >= mv){
            if (answer > p) {
                answer = Math.min(answer, p);
                answer_used = new ArrayList<>();
                for (Integer i : used) {
                    answer_used.add(i);
                }
            }
        }

        if (idx == n) {
            return;
        }

        used.add(idx+1);
        recursion(idx + 1, d + array.get(idx).dan, j + array.get(idx).ji,
                t + array.get(idx).tan, b + array.get(idx).bi, p + array.get(idx).price);
        used.remove(used.size()-1);

        recursion(idx + 1, d, j, t, b, p);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            array.add(new ingre(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())
            , Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        recursion(0, 0, 0, 0, 0, 0);

        if (!answer_used.isEmpty()) {
            System.out.println(answer);
            for (Integer i : answer_used) {
                System.out.print(i + " ");
            }
        }
        else System.out.println(-1);
        br.close();
    }
}
