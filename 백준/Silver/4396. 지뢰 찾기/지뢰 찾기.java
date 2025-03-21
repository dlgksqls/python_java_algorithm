import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static char[][] array;
    static char[][] result;
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        array = new char[n][n];
        result = new char[n][n];

        for (int i = 0; i < n; i++) {
            array[i] = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                result[i][j] = '.';
            }
        }

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                if (input.charAt(j) == 'x') {
                    if (array[i][j] == '*') {
                        stepbomb();
                        continue;
                    }
                    result[i][j] = (char) ('0' + countBombs(i, j));
                }
            }
        }
        printMap();
        br.close();
    }

    private static int countBombs(int x, int y) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (array[nx][ny] == '*') count++;
            }
        }
        return count;
    }

    private static void stepbomb() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == '*') {
                    result[i][j] = '*';
                }
            }
        }
    }

    private static void printMap() {
        for (int i = 0; i < n; i++) {
            System.out.println(result[i]);
        }
    }
}