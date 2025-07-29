import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int water = Integer.parseInt(st.nextToken());
            visited.add(water);
            queue.add(new int[]{water, 0});
        }

        long answer = 0;
        int[] dir = {-1, 1};
        while(!queue.isEmpty() && k > 0){
            int[] poll = queue.poll();
            int now = poll[0];
            int dist = poll[1];

            for(int i=0; i<2; i++){
                int nDir = now + dir[i];

                if (!visited.contains(nDir)){
                    visited.add(nDir);
                    answer += dist + 1;
                    k --;
                    queue.add(new int[]{nDir, dist + 1});
                    if (k == 0) break;
                }
            }
        }

        System.out.println(answer);

        br.close();
    }
}
