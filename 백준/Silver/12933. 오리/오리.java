import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static char[] input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().toCharArray();
        char[] quack = {'q', 'u', 'a', 'c', 'k'};
        int total = input.length;
        int answer = 0;

        if (input[0] != 'q' || input.length % 5 != 0){
            System.out.println(-1);
            return;
        }

        while(true){
            boolean flag = false;
            int[] temp = new int[5];
            int ptr = 0;
            int count = 0;
            for(int i=0; i<input.length; i++){
                if (input[i] == quack[ptr]){
                    temp[count ++] = i;
                    ptr ++;
                }
                if (ptr == 5){
                    flag = true;
                    count = 0;
                    total -= 5;
                    ptr = 0;
                    for (int j=0; j<temp.length; j++){
                        input[temp[j]] = 'x';
                    }
                }
            }
            if (flag) answer ++;
            else{
                System.out.println(-1);
                return;
            }
            if (total == 0) break;
        }
        System.out.println(answer);
    }
}
