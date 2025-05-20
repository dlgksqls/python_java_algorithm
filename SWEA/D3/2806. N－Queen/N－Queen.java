import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static int answer;

    // n-queen : 같은 행, 같은 열, 대각선에 있으면 안됨
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc ++){
            int n = Integer.parseInt(br.readLine());

            int[] array = new int[n+1]; // array[1] = 3; 1행 3열

            answer = 0;
            recursion(n, array, 1);

            System.out.println("#" + tc + " " + answer);
        }
    }

    private static void recursion(int n, int[] array, int row) {
        if (row > n){
            answer ++;
            return;
        }

        for(int i=1; i<=n; i++){
            array[row] = i;
            if (check(row, array)){
                recursion(n, array, row + 1);
            }
        }
    }

    private static boolean check(int row, int[] array) {
        for(int i=1; i<row; i++){
            if (array[i] == array[row] || Math.abs(array[i] - array[row]) == Math.abs(i - row)){
                return false;
            }
        }
        return true;
    }
}
