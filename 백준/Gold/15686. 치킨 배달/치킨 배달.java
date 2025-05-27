import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int answer;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] array = new int[n+1][n+1];
        ArrayList<Node> homes = new ArrayList<>();
        ArrayList<Node> chickens = new ArrayList<>();
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
                if (array[i][j] == 2){
                    chickens.add(new Node(i, j));
                }
                else if (array[i][j] == 1){
                    homes.add(new Node(i, j));
                }
            }
        }
        answer = Integer.MAX_VALUE;
        visited = new boolean[chickens.size()];

        recursion(0, 0, m, homes, chickens);

        System.out.println(answer);
        br.close();
    }

    private static void recursion(int idx, int depth, int m, ArrayList<Node> homes, ArrayList<Node> chickens) {
        if(depth == m){
            answer = Math.min(answer, calDis(homes, chickens));
            return;
        }

        for(int i=idx; i<chickens.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                recursion(i + 1, depth + 1, m, homes, chickens);
                visited[i] = false;
            }
        }
    }

    private static int calDis(ArrayList<Node> homes, ArrayList<Node> chickens) {
        int total = 0;
        for(Node home : homes){
            int min = Integer.MAX_VALUE;
            for(int i=0; i<chickens.size(); i++){
                if (visited[i]){
                    int dist = Math.abs(home.x - chickens.get(i).x) + Math.abs(home.y - chickens.get(i).y);
                    min = Math.min(min, dist);
                }
            }
            total += min;
        }
        return total;
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
