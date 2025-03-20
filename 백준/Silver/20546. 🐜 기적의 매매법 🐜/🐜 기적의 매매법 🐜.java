import java.io.*;
import java.util.*;

public class Main {

    static int money;
    static int count_seong;
    static int count_jun;
    static int[] array = new int[14];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        money = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<14; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        int jun_money = money;
        int seong_money = money;

        jun(jun_money, 0);
        seong(seong_money, 0);

        if (count_jun > count_seong) System.out.println("BNP");
        else if (count_jun < count_seong) System.out.println("TIMING");
        else System.out.println("SAMESAME");
    }

    private static void jun(int jun_money, int count) {
        for (int i=0; i<14; i++){
            if (jun_money >= array[i]) {
                count += jun_money / array[i];
                jun_money -= array[i] * (jun_money / array[i]);
            }
        }
        count_jun = jun_money + (array[13] * count);
    }

    private static void seong(int seong_money, int count) {
        int count_high = 0;
        int count_low = 0;
        int recent = array[0];

        for (int i=1; i<14; i++){
            if (recent > array[i]){
                count_high = 0;
                count_low ++;
            }
            else if (recent < array[i]){
                count_high ++;
                count_low = 0;
            }

            if (count_low >= 3){
                count += seong_money / array[i];
                seong_money -= array[i] * (seong_money / array[i]);
            }
            else if(count_high >= 3){
                seong_money += count * array[i];
                count = 0;
            }
            recent = array[i];
        }

        count_seong = seong_money + (array[13] * count);
    }
}
