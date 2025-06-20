import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);
        int max = cards[n-1];
        int answer = 0;

        for(int i=n-2; i>=0; i--){
            answer += max + cards[i];
        }

        System.out.println(answer);
        br.close();
    }
}
