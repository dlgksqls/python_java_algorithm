import java.io.*;
import java.util.*;

public class Main {
    static Integer input[] = new Integer[14];

    static int Jun(int money, Integer[] input) {
        int answer = 0;

        for (int i : input) {
            if (money >= i) {
                int buy = money / i;
                answer += buy;
                money -= i * buy;
            }
        }

        return answer * input[13] + money;
    }

    static int Seong(int money, Integer[] input){
        int answer = 0;
        int buffer = input[0];
        int upCount = 0;
        int downCount = 0;

        for (int i = 1; i < 14; i++){
            int today = input[i];

            if (today < buffer) {
                downCount++;
                upCount = 0;
            } else if (today > buffer) {
                upCount++;
                downCount = 0;
            } else {
                upCount = 0;
                downCount = 0;
            }

            buffer = today;

            if (downCount == 3) {
                int buy = money / today;
                answer += buy;
                money -= buy * today;
                downCount = 0;
            } else if (upCount == 3) {
                money += answer * today;
                answer = 0;
                upCount = 0;
            }
        }
        return money + answer * input[13];
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int money = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<14; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        if (Jun(money, input) > Seong(money, input))
            System.out.println("BNP");
        else if (Jun(money, input) < Seong(money, input))
            System.out.println("TIMING");
        else
            System.out.println("SAMESAME");
    }
}
