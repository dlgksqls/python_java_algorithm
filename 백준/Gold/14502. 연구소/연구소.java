import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph;
    static int[][] copy_graph;
    static boolean[] visited;
    static int answer;
    static ArrayList<Node> virus;
    static ArrayList<Node> safe;
    static ArrayList<Node> wall;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        safe = new ArrayList<>();
        virus = new ArrayList<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 0) {
                    safe.add(new Node(i, j));
                }
                if (graph[i][j] == 2){
                    virus.add(new Node(i, j));
                }
            }
        }

        visited = new boolean[safe.size()];
        wall = new ArrayList<>();
        answer = Integer.MIN_VALUE;

        recursion(0, 0);

        System.out.println(answer);
        br.close();
    }

    private static void recursion(int idx, int depth) {
        if (depth == 3){
            virus();
            return;
        }

        for(int i=idx; i<visited.length; i++){
            if (!visited[i]){
                visited[i] = true;
                wall.add(safe.get(i));
                recursion(i + 1, depth + 1);
                visited[i] = false;
                wall.remove(wall.size()-1);
            }
        }
    }

    private static void virus() {
        copy_graph = new int[graph.length][graph[0].length];

        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[0].length; j++){
                copy_graph[i][j] = graph[i][j];
            }
        }

        for (Node node : wall) {
            copy_graph[node.x][node.y] = 1;
        }
        for (Node node : virus) {
            dfs(node.x, node.y);
        }
        
        count();
    }

    private static void dfs(int x, int y) {
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < copy_graph.length && ny >= 0 && ny < copy_graph[0].length) {
                if (copy_graph[nx][ny] == 0){
                    copy_graph[nx][ny] = 1;
                    dfs(nx, ny);
                }
            }
        }
    }

    private static void count() {
        int result = 0;
        for(int i=0; i<copy_graph.length; i++){
            for(int j=0; j<copy_graph[0].length; j++){
                if(copy_graph[i][j] == 0) result ++;
            }
        }
        answer = Math.max(answer, result);
    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
