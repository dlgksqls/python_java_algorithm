import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] game = new int[15][2];
    static int[][] team;
    static boolean possible;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int idx = 0;
        for(int i=0; i<5; i++){
            for(int j=i+1; j<6; j++){
                game[idx][0] = i;
                game[idx][1] = j;

                idx ++;
            }
        }
        for(int i=0; i<4; i++){
            team = new int[6][3];
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<6; j++){
                for(int k=0; k<3; k++){
                    team[j][k] = Integer.parseInt(st.nextToken());
                    sum += team[j][k];
                }
            }

            if (sum != 30) {
                System.out.print(0 + " ");
                continue;
            }

            possible = false;
            recursion(0);
            System.out.print((possible ? 1 : 0) + " ");
        }

        br.close();
    }

    private static void recursion(int idx) {
        if (possible) return;
        if (idx == 15) {
            possible = true;
            return;
        }

        int teamA = game[idx][0];
        int teamB = game[idx][1];

        // 승, 패
        if (team[teamA][0] > 0 && team[teamB][2] > 0){
            team[teamA][0] --;
            team[teamB][2] --;

            recursion(idx + 1);

            team[teamA][0] ++;
            team[teamB][2] ++;
        }
        // 무
        if (team[teamA][1] > 0 && team[teamB][1] > 0){
            team[teamA][1] --;
            team[teamB][1] --;

            recursion(idx + 1);

            team[teamA][1] ++;
            team[teamB][1] ++;
        }
        // 패 승
        if (team[teamA][2] > 0 && team[teamB][0] > 0){
            team[teamA][2] --;
            team[teamB][0] --;

            recursion(idx + 1);

            team[teamA][2] ++;
            team[teamB][0] ++;
        }
    }
}
