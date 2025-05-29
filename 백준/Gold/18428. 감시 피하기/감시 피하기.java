import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static char[][] array;
    static ArrayList<Node> wall;
    static boolean answer = false;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        ArrayList<Node> teachers = new ArrayList<>();

        array = new char[n][n];
        for(int i=0; i<n ;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                array[i][j] = st.nextToken().charAt(0);
                if (array[i][j] == 'T') teachers.add(new Node(i, j));
            }
        }

        wall = new ArrayList<>();

        recursion(0, teachers);

        if (answer) {
            System.out.println("YES");
        }
        else System.out.println("NO");

        br.close();
    }

    private static void recursion(int depth, ArrayList<Node> teachers) {

        if (answer) return;

        if (depth == 3) {
            if (check(teachers)) {
                answer = true;
            }
            return;
        }

        for(int i=0; i<array.length; i++){
            for(int j=0; j<array.length; j++){
                if (array[i][j] == 'X') {
                    array[i][j] = 'O';
                    recursion(depth + 1, teachers);
                    array[i][j] = 'X';
                }
            }
        }
    }

    private static boolean check(ArrayList<Node> teachers) {
        for (Node teacher : teachers) {
            for(int dir=0; dir<4; dir++){
                int x = teacher.x;
                int y = teacher.y;

                while(true){
                    x += dx[dir];
                    y += dy[dir];

                    if (x >= 0 && x < array.length && y >= 0 && y < array.length){
                        if (array[x][y] == 'S') return false;
                        else if (array[x][y] == 'O') break;
                    }
                    else break;
                }
            }
        }
        return true;
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
