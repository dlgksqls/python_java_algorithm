import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 스위치 개수
        n = Integer.parseInt(br.readLine());
        array = new int[n + 1];

        // 스위치 상태 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int std_n = Integer.parseInt(br.readLine());

        for (int i = 0; i < std_n; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            if (sex == 1) {
                male(number);
            } else {
                female(number);
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(array[i] + " ");
            if (i % 20 == 0) System.out.println();
        }
        br.close();
    }
    
    private static void male(int number) {
        for (int i = number; i <= n; i += number) {
            array[i] = 1 - array[i];
        }
    }
    
    private static void female(int number) {
        array[number] = 1 - array[number];

        int start = number - 1;
        int end = number + 1;

        while (start >= 1 && end <= n && array[start] == array[end]) {
            array[start] = 1 - array[start];
            array[end] = 1 - array[end];
            start--;
            end++;
        }
    }
}
