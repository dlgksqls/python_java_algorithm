import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 100001;
    static boolean[] visited = new boolean[MAX];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(bfs(n, k));
        br.close();
    }

    private static int bfs(int n, int k) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n, 0}); // 현재 위치, time

        visited[n] = true;

        while(!queue.isEmpty()){
            int[] poll = queue.poll();

            int now = poll[0];
            int time = poll[1];

            if (now == k) return time;

            int[] nextMoves = {now + 1, now - 1, now * 2};
            for (int nextMove : nextMoves) {
                if (nextMove >= 0 && nextMove < MAX && !visited[nextMove]){
                    queue.add(new int[]{nextMove, time + 1});
                    visited[nextMove] = true;
                }
            }
        }
        return -1;
    }
}
