import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int count = 0;
        StringBuilder answer = new StringBuilder(); // StringBuilder를 사용하여 문자열 추가 성능 개선

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'X') {
                count++;
            } else if (input.charAt(i) == '.') {
                if (count % 2 != 0) {
                    System.out.println(-1);
                    return;
                }
                while (count >= 4) { // 'A'로 대체 가능한 만큼 대체
                    answer.append("AAAA");
                    count -= 4;
                }
                while (count >= 2) { // 'B'로 대체 가능한 만큼 대체
                    answer.append("BB");
                    count -= 2;
                }
                answer.append("."); // '.' 추가
                count = 0; // count 초기화
            }
        }

        // 마지막 문자가 'X'인 경우 처리
        if (count % 2 != 0) {
            System.out.println(-1);
            return;
        }
        while (count >= 4) {
            answer.append("AAAA");
            count -= 4;
        }
        while (count >= 2) {
            answer.append("BB");
            count -= 2;
        }

        bw.write(answer.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
