import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Egg{
        int s;
        int w;

        public Egg(int s, int w) {
            this.s = s;
            this.w = w;
        }
    }
    static int n;
    static Egg[] eggs;
    static int answer = Integer.MIN_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        eggs = new Egg[n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        visited = new boolean[n];
        recursion(0);

        System.out.println(answer);
        br.close();
    }

    private static void recursion(int idx) {
        if (idx == n) {
            int count = 0;
            for (Egg egg : eggs) {
                if (egg.s <= 0){
                    count ++;
                }
            }
            answer = Math.max(answer, count);
            return;
        }

        boolean flag = false;
        if (eggs[idx].s > 0){
            for(int i=0; i<n; i++){
                if (i == idx || eggs[i].s <= 0) continue;

                flag = true;
                int tmp_idx = eggs[idx].s;
                int tmp_i = eggs[i].s;

                eggs[idx].s -= eggs[i].w;
                eggs[i].s -= eggs[idx].w;

                recursion(idx + 1);

                eggs[idx].s = tmp_idx;
                eggs[i].s = tmp_i;
            }
        }

        if (!flag) recursion(idx + 1);
    }
}
