import java.util.*;

public class Solution {

    static int win;
    static int lose;
    static int[] gyu;
    static int[] inn;
    static boolean[] visited;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            win = 0;
            lose = 0;
            gyu = new int[9];
            inn = new int[9];
            visited = new boolean[9];
            for(int i=0; i<9; i++){
                gyu[i] = sc.nextInt();
            }

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j <= 18; j++) {
                    final int finalJ = j;
                    if (!Arrays.stream(gyu).anyMatch(x -> x == finalJ) && !Arrays.stream(inn).anyMatch(x -> x == finalJ)) {
                        inn[i] = j;
                        break;
                    }
                }
            }

            recursion(0, 0, 0);

            System.out.println("#" + tc + " " + win + " " + lose);
        }
    }

    private static void recursion(int idx, int gyu_score, int inn_score) {
        if (idx == 9){
            if (gyu_score > inn_score) win ++;
            else if (gyu_score < inn_score) lose ++;
            return;
        }

        for(int i=0; i<9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (gyu[idx] > inn[i]) {
                    recursion(idx + 1, gyu_score + gyu[idx] + inn[i], inn_score);
                } else {
                    recursion(idx + 1, gyu_score, inn_score + gyu[idx] + inn[i]);
                }
                visited[i] = false;
            }
        }
    }
}
