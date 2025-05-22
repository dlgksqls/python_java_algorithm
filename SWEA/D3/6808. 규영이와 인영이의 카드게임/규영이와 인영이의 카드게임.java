import java.util.*;

public class Solution {

    static int gyu_win;
    static int inn_win;
    static boolean[] visited_inn;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int[] gyu = new int[9];
            int[] inn = new int[9];

            boolean[] visited = new boolean[19];
            for(int i=0; i<9; i++){
                gyu[i] = sc.nextInt();
                visited[gyu[i]] = true;
            }

            int idx = 0;
            for(int i=1; i<=18; i++){
                if (!visited[i]) {
                    inn[idx] = i;
                    idx ++;
                }
            }

            gyu_win = 0;
            inn_win = 0;
            visited_inn = new boolean[9];
            recursion(0, 0, 0, gyu, inn);

            System.out.println("#" + tc + " " + gyu_win + " " + inn_win);
        }
    }

    private static void recursion(int idx, int gyu_score, int inn_score, int[] gyu, int[] inn) {
        if (idx == 9){
            if (gyu_score == inn_score) return;
            if (gyu_score > inn_score) gyu_win ++;
            else inn_win ++;
            return;
        }
        for(int i=0; i<9; i++){
            if (!visited_inn[i]){
                visited_inn[i] = true;
                if (gyu[idx] > inn[i]) {
                    recursion(idx + 1, gyu_score + gyu[idx] + inn[i], inn_score, gyu, inn);
                }
                else {
                    recursion(idx + 1, gyu_score, inn_score + gyu[idx] + inn[i], gyu, inn);
                }
                visited_inn[i] = false;
            }
        }
    }
}
