import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Flog{
        int[] talk = new int[5];
        Set<Integer> like = new HashSet<>();

        public Flog(int food, int interest, int family, int philosophy) {
            talk[1] = food;
            talk[2] = interest;
            talk[3] = family;
            talk[4] = philosophy;
        }
    }
    static class wood{
        int a;
        int b;
        int t;

        public wood(int a, int b, int t) {
            this.a = a;
            this.b = b;
            this.t = t;
        }
    }

    static int n, m;
    static boolean[] visited;
    static Flog[] flogs;
    static wood[] woods;
    static List<Integer> answer;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        flogs = new Flog[n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            flogs[i] = new Flog(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            flogs[i].like.add(a);
            flogs[i].like.add(b);
        }

        woods = new wood[m];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            woods[i] = new wood(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }

        visited = new boolean[n];
        answer = new ArrayList<>();

        recursion(0);

        if (!flag) System.out.println("NO");

        br.close();
    }

    private static void recursion(int depth) {
        if (flag) return;
        if (depth == n){
            flag = true;
            System.out.println("YES");
            for (Integer i : answer) {
                System.out.print((i+1) + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<n; i++){
            if (!visited[i]) {

                if (!flogs[i].like.contains(depth + 1)) {
                    continue; // 개구리 'i'가 연꽃 패드 '(depth + 1)'을 선호하지 않으면 다음 개구리 시도
                }

                visited[i] = true;
                answer.add(i);

                if (check(depth)) {
                    recursion(depth + 1);
                }

                visited[i] = false;
                answer.remove(answer.size() - 1);
            }
        }
    }

    private static boolean check(int depth) {
        for(int i=0; i<m; i++){
            wood wood = woods[i];

            if (wood.a-1 > depth || wood.b-1 > depth) {
                continue;
            }

            Integer firstFlog = answer.get(wood.a-1);
            Integer secondFlog = answer.get(wood.b-1);

            // 두 개구리의 관심도가 같은지
            if (flogs[firstFlog].talk[wood.t] != flogs[secondFlog].talk[wood.t]) return false;
        }
        return true;
    }
}
