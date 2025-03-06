import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class water{
        int a;
        int b;
        int c;

        public water(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static int a;
    static int b;
    static int c;
    static ArrayList<Integer> answer;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        answer = new ArrayList<>();
        visited = new boolean[a+1][b+1][c+1];

        bfs(0, 0, c);

        br.close();
    }

    private static void bfs(int aw, int bw, int cw) {
        Queue<water> queue = new LinkedList<>();
        queue.add(new water(aw, bw, cw));

        while (!queue.isEmpty()){
            water water = queue.poll();

            if (visited[water.a][water.b][water.c]){
                continue;
            }
            else {
                visited[water.a][water.b][water.c] = true;
            }
            if (water.a == 0){
                answer.add(water.c);
            }

            // a, b
            if (water.a + water.b > a){
                queue.add(new water(a, water.a + water.b - a, water.c));
            }
            else {
                queue.add(new water(water.a + water.b, 0, water.c));
            }
            if (water.a + water.b > b){
                queue.add(new water(water.a + water.b - b, b, water.c));
            }
            else{
                queue.add(new water(0, water.a + water.b, water.c));
            }

            // b, c
            if (water.b + water.c > b){
                queue.add(new water(water.a, b, water.b + water.c - b));
            }
            else {
                queue.add(new water(water.a, water.b + water.c, 0));
            }
            if (water.b + water.c > c){
                queue.add(new water(water.a, water.b + water.c - c, c));
            }
            else{
                queue.add(new water(water.a, 0, water.b + water.c));
            }

            // a, c
            if (water.a + water.c > a){
                queue.add(new water(a, water.b, water.a + water.c - a));
            }
            else{
                queue.add(new water(water.a + water.c, water.b, 0));
            }
            if (water.a + water.c > c){
                queue.add(new water(water.a + water.c - c, water.b, c));
            }
            else {
                queue.add(new water(0, water.b, water.a + water.c));
            }
        }

        TreeSet<Integer> treeSet = new TreeSet<>();
        for (Integer i : answer) {
            treeSet.add(i);
        }

        for (Integer i : treeSet) {
            System.out.print(i + " ");
        }
    }
}
