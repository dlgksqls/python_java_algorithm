import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] city;
    static ArrayList<Integer> history;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        city = new ArrayList[n];
        for(int i=0; i<n; i++){
            city[i] = new ArrayList<>();
        }

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                int value = Integer.parseInt(st.nextToken());
                city[i].add(value);
            }
        }

        visited = new boolean[n];
        history = new ArrayList<>();
        recursion(0);

        System.out.println(answer);
        br.close();
    }

    private static void recursion(int depth) {
        if (depth == city.length){
            int val = 0;
            int now = history.get(0);
            for(int i=1; i<history.size(); i++){
                int cost = city[now].get(history.get(i));
                if (cost == 0) return;
                val += cost;
                now = history.get(i);
            }

            int returnCost = city[now].get(history.get(0));
            if (returnCost == 0) return;
            val += returnCost;
            answer = Math.min(answer, val);
            return;
        }

        for(int i=0; i<n; i++){
            if (!visited[i]){
                visited[i] = true;
                history.add(i);
                recursion(depth + 1);
                visited[i] = false;
                history.remove(history.size()-1);
            }
        }
    }
}
