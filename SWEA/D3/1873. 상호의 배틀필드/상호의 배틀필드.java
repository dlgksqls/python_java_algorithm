import java.util.Scanner;

public class Solution {
    static int H, W;
    static char[][] array;
    static int nowX, nowY;
    static int[] dx = {0, 1, 0, -1}; // L, D, R, U
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            H = sc.nextInt();
            W = sc.nextInt();
            array = new char[H][W];

            for (int i = 0; i < H; i++) {
                String line = sc.next();
                for (int j = 0; j < W; j++) {
                    array[i][j] = line.charAt(j);
                    if (array[i][j] == '>' || array[i][j] == 'v' || array[i][j] == '<' || array[i][j] == '^') {
                        nowX = i;
                        nowY = j;
                    }
                }
            }

            int N = sc.nextInt();
            String order = sc.next();

            // 명령어 처리
            for (int i = 0; i < N; i++) {
                char cmd = order.charAt(i);
                play(cmd);
            }

            // 결과 출력
            System.out.print("#" + tc + " ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(array[i][j]);
                }
                System.out.println();
            }
        }
        sc.close();
    }

    private static void play(char cmd) {
        switch (cmd) {
            case 'R':
                move(0, '>');
                break;
            case 'D':
                move(1, 'v');
                break;
            case 'L':
                move(2, '<');
                break;
            case 'U':
                move(3, '^');
                break;
            case 'S':
                shoot();
                break;
        }
    }

    private static void move(int dir, char tank_dir) {
        array[nowX][nowY] = tank_dir;

        int nx = nowX + dx[dir];
        int ny = nowY + dy[dir];

        if (nx >= 0 && nx < H && ny >= 0 && ny < W && array[nx][ny] == '.') {
            array[nowX][nowY] = '.';
            nowX = nx;
            nowY = ny;
            array[nowX][nowY] = tank_dir;
        }
    }

    private static void shoot() {
        int dir = 0;
        char tankShape = array[nowX][nowY];

        if (tankShape == '>') dir = 0;
        else if (tankShape == 'v') dir = 1;
        else if (tankShape == '<') dir = 2;
        else if (tankShape == '^') dir = 3;

        int nx = nowX;
        int ny = nowY;

        while (true) {
            nx += dx[dir];
            ny += dy[dir];

            if (nx < 0 || nx >= H || ny < 0 || ny >= W) break;

            if (array[nx][ny] == '#') break;

            if (array[nx][ny] == '*') {
                array[nx][ny] = '.';
                break;
            }
        }
    }
}