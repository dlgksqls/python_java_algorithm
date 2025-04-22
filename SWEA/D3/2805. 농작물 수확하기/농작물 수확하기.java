import java.util.*;
public class Solution {
    static int n;
    static int answer;
    static char [][] char_array;
    static int [][] array;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int count = 0;
            int idx = 0;
            n = sc.nextInt();
            char_array = new char[n][n];
            array = new int[n][n];
;
            answer = 0;
            int mid = n / 2;

            for(int i=0; i<n; i++){
                char_array[i] = sc.next().toCharArray();
                for(int j=0; j<n; j++){
                    array[i][j] = char_array[i][j] - '0';
                }
            }

            for(int i=0; i<n; i++){
                if (answer == 0){
                    for(int j=0; j<n; j++){
                        answer += array[j][mid];
                    }
                    idx ++;
                }
                else {
                    int left = mid - idx;
                    int right = mid + idx;
                    count += 1;

                    // 왼쪽
                    cal(left, count);
                    // 오른쪽
                    cal(right, count);

                    idx++;
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }

    private static void cal(int dir, int count) {
        for(int i=count; i<n-count; i++){
            answer += array[i][dir];
        }
    }
}
