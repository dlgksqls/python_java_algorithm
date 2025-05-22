import java.util.*;

public class Solution {
    static int[][] array;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for(int tc = 1; tc <= T; tc ++){
            int p = sc.nextInt();
            int q = sc.nextInt();

            array = new int[301][301];
            init();

            int x1 = 0, y1 = 0;
            int x2 = 0, y2 = 0;
            for(int i=1; i<=300; i++){
                for(int j=1; j<=300; j++){
                    if (array[i][j] == p){
                        x1 = i;
                        y1 = j;
                    }
                    if (array[i][j] == q){
                        x2 = i;
                        y2 = j;
                    }
                }
            }
            System.out.println("#" + tc + " " + array[x1+x2][y1+y2]);
        }
    }

    private static void init() {
        int count = 1;
        array[1][1] = 1;
        for(int i=2; i<=300; i++){
            array[i][1] = array[i-1][1] + count;
            count ++;
        }

        count = 2;
        for(int i=1; i<=300; i++){
            int up = count;
            for(int j=2; j<=300; j++){
                array[i][j] = array[i][j-1] + up;
                up ++;
            }
            count ++;
        }
    }
}
