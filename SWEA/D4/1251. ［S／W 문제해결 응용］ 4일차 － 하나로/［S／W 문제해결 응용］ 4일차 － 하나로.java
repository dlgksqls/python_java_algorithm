import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc ++){
            int n = Integer.parseInt(br.readLine());
            double[] arr_x = new double[n];
            double[] arr_y = new double[n];

            boolean[] visited = new boolean[n];
            double[] edge_dis = new double[n];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                arr_x[i] = Double.parseDouble(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                arr_y[i] = Double.parseDouble(st.nextToken());
                edge_dis[i] = Double.MAX_VALUE;
            }

            double e = Double.parseDouble(br.readLine());

            edge_dis[0] = 0;
            double answer = 0;

            // 크루스칼
            for(int i=0; i<n; i++){
                double min = Double.MAX_VALUE;
                int idx = -1;

                for(int j=0; j<n; j++) {
                    if (!visited[j] && edge_dis[j] < min) {
                        min = edge_dis[j];
                        idx = j;
                    }
                }

                answer += min;
                visited[idx] = true;

                for(int j=0; j<n; j++){
                    if (!visited[j]){
                        double dist = Math.pow(arr_x[idx] - arr_x[j], 2) + Math.pow(arr_y[idx] - arr_y[j], 2);
                        if (edge_dis[j] > dist) edge_dis[j] = dist;
                    }
                }
            }
            System.out.println("#" + tc + " " + Math.round(answer * e));
        }
        br.close();
    }
}
