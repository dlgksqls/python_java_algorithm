import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
    static int result = 0;
    static Integer[][] graph = new Integer[5][5];

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i< graph.length; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<graph[i].length; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k=0; k<5; k++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int m=0; m<5; m++) {
                int num = Integer.parseInt(st.nextToken());
                result ++ ;

                for (int i = 0; i < graph.length; i++) {
                    for (int j = 0; j < graph[i].length; j++) {
                        if (graph[i][j] == num) {
                            graph[i][j] = 0;
                        }
                    }
                }

                count = 0;

                rCheck();
                cCheck();
                rcCheck();
                lcCheck();

                if (count >= 3){
                    System.out.println(result);
                    return;
                }
            }
        }
    }
    private static void cCheck() {
        for (int i=0; i< graph.length; i++){
            boolean win = true;
            for (int j=0; j< graph.length; j++){
                if (graph[j][i] != 0){
                    win = false;
                    break;
                }
            }
            if (win) count ++;
        }
    }
    private static void rCheck() {
        for (int i=0; i< graph.length; i++){
            boolean win = true;
            for (int j=0; j< graph.length; j++){
                if (graph[i][j] != 0){
                    win = false;
                    break;
                }
            }
            if (win) count ++;
        }
    }
    private static void lcCheck() {
        boolean win = true;
        for (int i=0; i<graph.length; i++){
            if(graph[i][i] != 0){
                win = false;
                break;
            }
        }
        if (win) count ++;
    }

    private static void rcCheck() {
        boolean win = true;
        for (int i=0; i<graph.length; i++){
            if(graph[i][graph.length - i - 1] != 0){
                win = false;
                break;
            }
        }
        if(win) count ++;
    }
}
