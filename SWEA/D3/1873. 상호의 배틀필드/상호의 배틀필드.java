import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int h, w;
    static int nowX, nowY;
    static char[][] array;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc ++){
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            String input = "";
            array = new char[h][w];

            for(int i=0; i<h; i++){
                input = br.readLine();
                for(int j=0; j<w; j++){
                    array[i][j] = input.charAt(j);
                    if (input.charAt(j) == '>' || input.charAt(j) == 'v' || input.charAt(j) == '<' || input.charAt(j) == '^'){
                        nowX = i;
                        nowY = j;
                    }
                }
            }
            int num = Integer.parseInt(br.readLine());
            String order = br.readLine();

            for(int i=0; i<num; i++){
                switch (order.charAt(i)){
                    case 'R' : move(0, '>'); break;
                    case 'D' : move(1, 'v'); break;
                    case 'L' : move(2, '<'); break;
                    case 'U' : move(3, '^'); break;
                    case 'S' : shoot(); break;
                }
            }

            System.out.print("#" + tc + " ");
            for (char[] arrays : array) {
                for (char aChar : arrays) {
                    System.out.print(aChar);
                }
                System.out.println();
            }
        }
    }

    private static void move(int idx, char dir) {
        int nx = nowX + dx[idx];
        int ny = nowY + dy[idx];

        if (nx >= 0 && nx < h && ny >= 0 && ny < w && array[nx][ny] == '.'){
            array[nowX][nowY] = '.';
            nowX = nx;
            nowY = ny;
        }
        array[nowX][nowY] = dir;
    }
    private static void shoot() {
        int dir = 0;
        char nowDir = array[nowX][nowY];

        switch (nowDir){
            case '>' : dir = 0; break;
            case 'v' : dir = 1; break;
            case '<' : dir = 2; break;
            case '^' : dir = 3; break;
        }

        int nx = nowX;
        int ny = nowY;

        while(true){
            nx += dx[dir];
            ny += dy[dir];

            if (nx < 0 || nx >= h || ny < 0 || ny >= w) break;

            if (array[nx][ny] == '#') break;

            if (array[nx][ny] == '*'){
                array[nx][ny] = '.';
                break;
            }
        }
    }
}