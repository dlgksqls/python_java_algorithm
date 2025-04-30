import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T;
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] space_price = new int[n + 1];
            boolean[] is_space = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                space_price[i] = Integer.parseInt(br.readLine());
            }

            int[] car_weight = new int[m + 1];
            int[] car_idx = new int[m + 1];
            for (int i = 1; i <= m; i++) {
                car_weight[i] = Integer.parseInt(br.readLine());
                car_idx[i] = -1;
            }

            Queue<Integer> wait = new LinkedList<>();
            int answer = 0;

            for (int i = 0; i < 2 * m; i++) {
                int car = Integer.parseInt(br.readLine());

                if (car > 0) {
                    int possible = -1;
                    for (int j = 1; j <= n; j++) {
                        if (!is_space[j]) {
                            possible = j;
                            break;
                        }
                    }

                    if (possible == -1) wait.add(car);
                    else {
                        is_space[possible] = true;
                        car_idx[car] = possible;
                        answer += car_weight[car] * space_price[possible];
                    }
                } else {
                    car = Math.abs(car);
                    int possible = car_idx[car];
                    is_space[possible] = false;
                    car_idx[car] = -1;

                    if (!wait.isEmpty()) {
                        int wait_car = wait.poll();
                        is_space[possible] = true;
                        car_idx[wait_car] = possible;
                        answer += car_weight[wait_car] * space_price[possible];
                    }
                }
            }
            System.out.println("#" + tc + " " + answer);
        }
    }
}
