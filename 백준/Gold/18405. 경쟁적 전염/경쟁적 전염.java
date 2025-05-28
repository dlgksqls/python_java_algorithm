import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int n = Integer.parseInt(st.nextToken());;
        int k = Integer.parseInt(st.nextToken());;
        int[][] array = new int[n+1][n+1];
        ArrayList<Node> virus = new ArrayList<>();

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
                if (array[i][j] != 0) virus.add(new Node(array[i][j], 0, i, j));
            }
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        Collections.sort(virus);

        Queue<Node> queue = new LinkedList<>(virus);
        while(!queue.isEmpty()){
            Node poll = queue.poll();

            if (poll.time == s) break;
            for(int i=0; i<4; i++){
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];

                if (nx >= 0 && nx <= n && ny >= 0 && ny <= n && array[nx][ny] == 0){
                    array[nx][ny] = poll.num;
                    queue.add(new Node(poll.num, poll.time + 1, nx, ny));
                }
            }
        }

        System.out.println(array[x][y]);
        br.close();
    }

    private static class Node implements Comparable<Node>{
        int num;
        int time;
        int x;
        int y;

        public Node(int num, int time, int x, int y) {
            this.num = num;
            this.time = time;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node n){
            return Integer.compare(this.num, n.num);
        }
    }
}
