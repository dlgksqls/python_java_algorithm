import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine()); // 총 인원 수
        int t = Integer.parseInt(br.readLine()); // 턴 수
        int gu = Integer.parseInt(br.readLine()); // 뻔(0) 또는 데기(1)

        int result = play(a, t, gu);

        System.out.println(result);
    }

    static int play(int a, int t, int gu) {
        int count_bun = 0; // 뻔의 카운트
        int count_de = 0;  // 데기의 카운트
        int n = 2; // 턴의 증가 수
        
        while (true) {
            // 4번 반복 (뻔과 데기 각각 2번씩)
            for (int i = 0; i < 4; i++) {
                if (i % 2 == 0) { // 뻔 턴
                    count_bun++;
                    if (count_bun == t && gu == 0) {
                        return (count_bun + count_de - 1) % a;
                    }
                } else { // 데기 턴
                    count_de++;
                    if (count_de == t && gu == 1) {
                        return (count_bun + count_de - 1) % a;
                    }
                }
            }

            // n번 반복 (뻔 턴)
            for (int i = 0; i < n; i++) {
                count_bun++;
                if (count_bun == t && gu == 0) {
                    return (count_bun + count_de - 1) % a;
                }
            }

            // n번 반복 (데기 턴)
            for (int i = 0; i < n; i++) {
                count_de++;
                if (count_de == t && gu == 1) {
                    return (count_bun + count_de - 1) % a;
                }
            }
            n++; // n 증가
        }
    }
}
