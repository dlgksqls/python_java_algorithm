import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 100001;
    static int[] time = new int[MAX];
    static int[] count = new int[MAX];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bfs(n, k);

        System.out.println(time[k]);
        System.out.println(count[k]);
        br.close();
    }

    private static void bfs(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        time[n] = 0;
        count[n] = 1;

        while(!queue.isEmpty()){
            int now = queue.poll();

            int[] nextMoves = {now + 1, now - 1, now * 2};
            for (int nextMove : nextMoves) {
                if (nextMove >= 0 && nextMove < MAX){
                    if (time[nextMove] == 0 && nextMove != n){
                        time[nextMove] = time[now] + 1;
                        count[nextMove] = count[now];
                        queue.add(nextMove);
                    }
                    else if (time[nextMove] == time[now] + 1) {
                        count[nextMove] += count[now];
                    }
                }
            }
        }
    }
}
