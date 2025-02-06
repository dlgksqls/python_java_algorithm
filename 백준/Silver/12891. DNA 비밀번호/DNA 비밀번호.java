import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /**
     * 첫 번째 줄에 민호가 임의로 만든 DNA 문자열 길이 |S|와 비밀번호로 사용할 부분문자열의 길이 |P| 가 주어진다. (1 ≤ |P| ≤ |S| ≤ 1,000,000)
     * 두번 째 줄에는 민호가 임의로 만든 DNA 문자열이 주어진다.
     * 세번 째 줄에는 부분문자열에 포함되어야 할 {‘A’, ‘C’, ‘G’, ‘T’} 의 최소 개수가 공백을 구분으로 주어진다.
     * 각각의 수는 |S| 보다 작거나 같은 음이 아닌 정수이며 총 합은 |S| 보다 작거나 같음이 보장된다.
     *
     * 입력
     * 9 8
     * CCTGGATTG
     * 2 0 1 1
     */

    static int[] dna = new int[4];
    static int[] check_dna = new int[4];
    static int checkSecret = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int answer = 0;

        String dna_sen = br.readLine();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            dna[i] = Integer.parseInt(st.nextToken());
            if (dna[i] == check_dna[i]){
                checkSecret ++;
            }
        }
        
        for (int i=0; i<p; i++){
            add_check(dna_sen.charAt(i));
        }

        if (checkSecret == 4){
            answer ++;
        }

        for (int i=p; i<s; i++){
            int start_index = i - p;
            int end_index = i;

            add_check(dna_sen.charAt(end_index));
            remove_check(dna_sen.charAt(start_index));

            if (checkSecret == 4){
                answer ++;
            }
        }
        System.out.println(answer);
        br.close();
    }

    private static void add_check(char c) {
        switch (c){
            case 'A':
                check_dna[0] ++;
                if (dna[0] == check_dna[0]){
                    checkSecret ++;
                }
                break;
            case 'C':
                check_dna[1] ++;
                if (dna[1] == check_dna[1]){
                    checkSecret ++;
                }
                break;
            case 'G':
                check_dna[2] ++;
                if (dna[2] == check_dna[2]){
                    checkSecret ++;
                }
                break;
            case 'T':
                check_dna[3] ++;
                if (dna[3] == check_dna[3]){
                    checkSecret ++;
                }
                break;
        }
    }

    private static void remove_check(char c) {
        switch (c){
            case 'A':
                if (dna[0] == check_dna[0]){
                    checkSecret --;
                }
                check_dna[0] --;
                break;
            case 'C':
                if (dna[1] == check_dna[1]){
                    checkSecret --;
                }
                check_dna[1] --;
                break;
            case 'G':
                if (dna[2] == check_dna[2]){
                    checkSecret --;
                }
                check_dna[2] --;

                break;
            case 'T':
                if (dna[3] == check_dna[3]){
                    checkSecret --;
                }
                check_dna[3] --;
                break;
        }
    }
}
