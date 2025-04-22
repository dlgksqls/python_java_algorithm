import java.io.*;
import java.util.*;

public class Main {
    static char[][] graph = new char[12][6];
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
            graph[i] = br.readLine().toCharArray();
        }

        while (true) {
            boolean boom = false;
            visited = new boolean[12][6];

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (graph[i][j] != '.' && !visited[i][j]) {
                        List<int[]> group = bfs(i, j, graph[i][j]);
                        if (group.size() >= 4) {
                            boom = true;
                            for (int[] p : group) {
                                graph[p[0]][p[1]] = '.';
                            }
                        }
                    }
                }
            }

            if (!boom) break; // 터뜨린게 없다

            drop(); // 블럭 아래로 내리기
            answer++;
        }

        System.out.println(answer);
    }

    static List<int[]> bfs(int x, int y, char color) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> group = new ArrayList<>();
        visited[x][y] = true;
        queue.add(new int[]{x, y});
        group.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx >= 0 && nx < 12 && ny >= 0 && ny < 6) {
                    if (!visited[nx][ny] && graph[nx][ny] == color) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                        group.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return group;
    }

    static void drop() {
        for (int j = 0; j < 6; j++) {
            Queue<Character> queue = new LinkedList<>();

            for (int i = 11; i >= 0; i--) {
                if (graph[i][j] != '.') {
                    queue.add(graph[i][j]);
                    graph[i][j] = '.';
                }
            }

            int row = 11;
            while (!queue.isEmpty()) {
                graph[row--][j] = queue.poll();
            }
        }
    }
}