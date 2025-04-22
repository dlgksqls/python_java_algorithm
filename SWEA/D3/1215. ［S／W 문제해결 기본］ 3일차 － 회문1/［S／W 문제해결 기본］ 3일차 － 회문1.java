import java.util.*;

public class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int n = sc.nextInt();
            int answer = 0;
            char[][] array = new char[8][8];

            for (int i = 0; i < 8; i++) {
                array[i] = sc.next().toCharArray();
            }

            // 방향: 오른쪽, 아래
            int[] dx = {0, 1};
            int[] dy = {1, 0};

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    for (int d = 0; d < 2; d++) {
                        int nx = i + dx[d] * (n - 1);
                        int ny = j + dy[d] * (n - 1);

                        // 범위 초과 확인
                        if (nx >= 8 || ny >= 8) continue;

                        boolean flag = true;

                        for (int k = 0; k < n / 2; k++) {
                            int sx = i + dx[d] * k;
                            int sy = j + dy[d] * k;

                            int ex = i + dx[d] * (n - 1 - k);
                            int ey = j + dy[d] * (n - 1 - k);

                            if (array[sx][sy] != array[ex][ey]) {
                                flag = false;
                                break;
                            }
                        }

                        if (flag) answer++;
                    }
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}
