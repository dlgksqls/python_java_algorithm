import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static ArrayList<Integer>[] graph;
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[n+1];
        graph = new ArrayList[n+1];
        for (int i=0; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            array[b] ++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i< array.length; i++){
            if (array[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int now = queue.poll();
            System.out.print(now + " ");
            for(int index : graph[now]){
                array[index] --;
                if (array[index] == 0){
                    queue.offer(index);
                }
            }
        }
    }
}
