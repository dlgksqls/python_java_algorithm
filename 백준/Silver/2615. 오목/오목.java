import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] array = new int[19][19];
        for(int i=0; i<19; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<19; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = {0, 1, 1, -1}; // → ↓ ↘ ↗
        int[] dy = {1, 0, 1, 1};


        for(int i=0; i<19; i++){
            for(int j=0; j<19; j++){
                if(array[i][j] != 0){
                    int color = array[i][j];

                    for(int k=0; k<4; k++){
                        int cnt = 1;
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        while(nx >= 0 && nx < 19 && ny >= 0 && ny < 19 && array[nx][ny] == color){
                            cnt ++;
                            if (cnt > 5){
                                break;
                            }
                            nx += dx[k];
                            ny += dy[k];
                        }

                        if (cnt == 5){
                            // 이전 방향 확인
                            int px = i - dx[k];
                            int py = j - dy[k];
                            if (px >= 0 && px < 19 && py >= 0 && py < 19 && array[px][py] == color) continue;

                            System.out.println(color);
                            System.out.println((i + 1) + " " + (j + 1));
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(0);
        br.close();
    }
}
