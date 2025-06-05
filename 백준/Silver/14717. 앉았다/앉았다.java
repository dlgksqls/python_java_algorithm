import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> card = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10));

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        card.remove(Integer.valueOf(a));
        card.remove(Integer.valueOf(b));

        double win = 0;

        if(a == b) {
            for(int i=0; i<card.size()-1; i++) {
                if(card.get(i) == card.get(i + 1) && card.get(i) > a) {
                    win++;
                }
            }
            win = 153 - win;
        }
        else {
            int num = (a+b) % 10;
            for(int i=0; i<card.size(); i++) {
                for(int j=i; j<card.size(); j++) {
                    if(i == j) continue;
                    else {
                        if((((card.get(i) + card.get(j)) % 10) < num) && card.get(i) != card.get(j)) {
                            win++;
                        }
                    }
                }
            }
        }

        double total = win / 153;
        System.out.printf("%.3f", total);
    }
}