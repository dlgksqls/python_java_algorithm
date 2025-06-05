import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] array = new char[n][m];

        for(int i=0; i<n; i++){
            array[i] = br.readLine().toCharArray();
        }

        int answer = Integer.MAX_VALUE;
        for(int i=0; i<=n-8; i++){
            for(int j=0; j<=m-8; j++){
                int draw1 = 0;
                int draw2 = 0;

                for(int k=0; k<8; k++){
                    for(int l=0; l<8; l++){
                        char current = array[i + k][j + l];
                        if ((k + l) % 2 == 0) {
                            if (current != 'W') draw1++;
                            if (current != 'B') draw2++;
                        } else {
                            if (current != 'B') draw1++;
                            if (current != 'W') draw2++;
                        }
                    }
                }
                answer = Math.min(answer, Math.min(draw1, draw2));
            }
        }

        System.out.println(answer);
        br.close();
    }
}
