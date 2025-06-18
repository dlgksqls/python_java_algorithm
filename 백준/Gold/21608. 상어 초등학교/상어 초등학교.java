import java.io.*;
import java.util.*;

public class Main {
    static int[][] classRoom;
    static Map<Integer, ArrayList<Integer>> friend = new HashMap<>();
    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        classRoom = new int[n][n];
        int[] order = new int[n * n];

        for (int i = 0; i < n * n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int stu = Integer.parseInt(st.nextToken());
            order[i] = stu;
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            friend.put(stu, list);
        }

        for (int idx = 0; idx < order.length; idx++) {
            int stu = order[idx];
            placeStudent(stu);
        }

        System.out.println(calculateSatisfaction());
    }

    static void placeStudent(int stu) {
        int maxLike = -1, maxBlank = -1;
        int selX = -1, selY = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (classRoom[i][j] != 0) continue;

                int like = 0;
                int blank = 0;

                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if (classRoom[nx][ny] == 0) blank++;
                    else if (friend.get(stu).contains(classRoom[nx][ny])) like++;
                }

                if (like > maxLike ||
                        (like == maxLike && blank > maxBlank) ||
                        (like == maxLike && blank == maxBlank && (i < selX || (i == selX && j < selY)))) {
                    maxLike = like;
                    maxBlank = blank;
                    selX = i;
                    selY = j;
                }
            }
        }

        classRoom[selX][selY] = stu;
    }

    static int calculateSatisfaction() {
        int score = 0;
        int[] scoreTable = {0, 1, 10, 100, 1000};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int stu = classRoom[i][j];
                int like = 0;

                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if (friend.get(stu).contains(classRoom[nx][ny])) like++;
                }

                score += scoreTable[like];
            }
        }

        return score;
    }
}