import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static ArrayList<Integer>[] graph;
    static int[] check;
    static int[] build_time;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        check = new int[n+1];
        build_time = new int[n+1];
        result = new int[n+1];

        for(int i=0; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            build_time[i] = time;
            result[i] = time;

            while(true){
                int a = Integer.parseInt(st.nextToken());
                if (a == -1) break;
                graph[a].add(i);
                check[i] ++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i=1; i<=n; i++){
            if (check[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int now = queue.poll();
            for (int i : graph[now]){
                check[i] --;
                if (check[i] == 0) queue.offer(i);
                result[i] = Math.max(result[i], result[now] + build_time[i]);
            }
        }

        for(int i=1; i<=n; i++){
            System.out.println(result[i]);
        }
    }
}
