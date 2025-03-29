import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class NumberBaseball{
        int number;
        int strike;
        int ball;

        public NumberBaseball(int number, int strike, int ball) {
            this.number = number;
            this.strike = strike;
            this.ball = ball;
        }
    }
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int answer = 0;

        NumberBaseball[] array = new NumberBaseball[n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            array[i] = new NumberBaseball(number, strike, ball);
        }

        for(int i=1; i<10; i++){
            for(int j=1; j<10; j++){
                for(int k=1; k<10; k++){
                    if (i == j || j == k || k == i) continue;

                    int count = 0;
                    int candidate = i * 100 + j * 10 + k;

                    for (NumberBaseball numberBaseball : array) {
                        int number = numberBaseball.number;
                        int strike = numberBaseball.strike;
                        int ball = numberBaseball.ball;

                        int strike_count = 0;
                        int ball_count = 0;

                        String candidateStr = String.valueOf(candidate);
                        String numberStr = String.valueOf(number);

                        for (int l=0; l<3; l++){
                            if (candidateStr.charAt(l) == numberStr.charAt(l)) strike_count ++;
                            else if (numberStr.indexOf(candidateStr.charAt(l)) !=-1) ball_count ++;
                        }

                        if (strike == strike_count && ball == ball_count) count ++;
                    }
                    if (count == n){
                        answer ++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
