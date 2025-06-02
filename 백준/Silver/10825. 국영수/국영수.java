import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 국어 점수가 감소하는 순서로
 * 2. 국어 점수가 같으면 영어 점수가 증가하는 순서로
 * 3. 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
 * 4. 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        students[] array = new students[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            array[i] = new students(
                    st.nextToken(),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }

        Arrays.sort(array);

        for (students students : array) {
            System.out.println(students.name);
        }

        br.close();
    }

    static class students implements Comparable<students> {
        String name;
        int korea;
        int english;
        int math;

        public students(String name, int korea, int english, int math) {
            this.name = name;
            this.korea = korea;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(students s) {
            if (this.korea == s.korea) {
                if (this.english == s.english) {
                    if (this.math == s.math) {
                        return this.name.compareTo(s.name);
                    }
                    return Integer.compare(s.math, this.math);
                } else {
                    return Integer.compare(this.english, s.english);
                }
            }
            return Integer.compare(s.korea, this.korea);
        }
    }
}
