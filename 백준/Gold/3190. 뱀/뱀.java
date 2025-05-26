import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] array;
    static Order[] orders;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int answer = 0;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        array = new int[n+1][n+1];

        int apple = Integer.parseInt(br.readLine());
        for(int i=0; i<apple; i++){
            st = new StringTokenizer(br.readLine());
            array[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        int orderCount = Integer.parseInt(br.readLine());
        orders = new Order[orderCount];
        for(int i=0; i<orderCount; i++){
            st = new StringTokenizer(br.readLine());
            orders[i] = new Order(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
        }

        simulate();
        System.out.println(answer);

        br.close();
    }

    private static void simulate() {
        int x = 1;
        int y = 1;
        int dir = 0;
        int idx = 0;
        array[x][y] = 2;

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(x, y));

        while(true){
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx >= 1 && nx <= n && ny >= 1 && ny <= n && array[nx][ny] != 2){
                if (array[nx][ny] == 1){
                    array[nx][ny] = 2;
                    queue.add(new Position(nx, ny));
                }
                else {
                    queue.add(new Position(nx, ny));
                    array[nx][ny] = 2;
                    Position poll = queue.poll();
                    array[poll.x][poll.y] = 0;
                }
            }
            else{
                answer ++;
                return;
            }

            x = nx;
            y = ny;
            answer ++;
            if (idx < orders.length && answer == orders[idx].time){
                if (orders[idx].dir == 'L') {
                    dir = (dir + 3) % 4; // 왼쪽으로 90도
                } else {
                    dir = (dir + 1) % 4; // 오른쪽으로 90도
                }
                idx ++;
            }
        }
    }

    private static class Order {
        int time;
        char dir;

        public Order(int time, char dir) {
            this.time = time;
            this.dir = dir;
        }
    }

    private static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
