import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc ++){
            String input = br.readLine();
            int answer = 0;
            int count = 0;

            for(int i=0; i<input.length(); i++){
                if (input.charAt(i) == '('){
                    count ++;
                }
                else {
                    count --;
                    if (input.charAt(i-1) == '('){
                        answer += count;
                    }
                    else{
                        answer ++;
                    }
                }
            }

            System.out.println("#" + tc + " " + answer);
        }

        br.close();
    }
}
