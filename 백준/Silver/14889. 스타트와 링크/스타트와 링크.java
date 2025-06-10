import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer> team1;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] array = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n+1];
        team1 = new ArrayList<>();
        recursion(1, n, array);
        System.out.println(answer);

        br.close();
    }

    private static void recursion(int idx, int n, int[][] array) {
        if (team1.size() == n / 2){
            ArrayList<Integer> team2 = new ArrayList<>();

            int team1_num = 0;
            int team2_num = 0;
            for(int i=1; i<=n; i++){
                if (!team1.contains(i)){
                    team2.add(i);
                }
            }

            for(int i=0; i<team1.size(); i++){
                for(int j=i+1; j<team1.size(); j++){
                    int a = team1.get(i);
                    int b = team1.get(j);
                    team1_num += array[a][b] + array[b][a];

                    a = team2.get(i);
                    b = team2.get(j);
                    team2_num += array[a][b] + array[b][a];
                }
            }

            answer = Math.min(answer, Math.abs(team1_num - team2_num));
            return;
        }

        for(int i=idx; i<=n; i++){
            if (!visited[i]){
                visited[i] = true;
                team1.add(i);
                recursion(i+1, n, array);
                team1.remove(team1.size()-1);
                visited[i] = false;
            }
        }
    }
}
