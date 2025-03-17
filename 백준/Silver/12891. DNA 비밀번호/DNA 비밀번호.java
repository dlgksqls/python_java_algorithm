import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int s;
    static int p;
    static char[] dnaArray;
    static int[] check_count = new int[4]; // A, C, G, T
    static int[] dna_count = new int[4];  // A, C, G, T
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        dnaArray = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            check_count[i] = Integer.parseInt(st.nextToken());
        }

        // 초기 윈도우 설정
        for (int i = 0; i < p; i++) {
            addChar(dnaArray[i]);
        }
        checkCondition();

        // 슬라이딩 윈도우 이동
        for (int i = p; i < s; i++) {
            removeChar(dnaArray[i - p]);
            addChar(dnaArray[i]);
            checkCondition();
        }

        System.out.println(answer);
    }

    private static void addChar(char c) {
        switch (c) {
            case 'A': dna_count[0]++; break;
            case 'C': dna_count[1]++; break;
            case 'G': dna_count[2]++; break;
            case 'T': dna_count[3]++; break;
        }
    }

    private static void removeChar(char c) {
        switch (c) {
            case 'A': dna_count[0]--; break;
            case 'C': dna_count[1]--; break;
            case 'G': dna_count[2]--; break;
            case 'T': dna_count[3]--; break;
        }
    }

    private static void checkCondition() {
        if (dna_count[0] >= check_count[0] &&
                dna_count[1] >= check_count[1] &&
                dna_count[2] >= check_count[2] &&
                dna_count[3] >= check_count[3]) {
            answer++;
        }
    }
}