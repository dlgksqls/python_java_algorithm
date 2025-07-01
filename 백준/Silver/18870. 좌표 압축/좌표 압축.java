import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] origin = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            origin[i] = num;
            set.add(num);
        }

        List<Integer> sortedList = new ArrayList<>(set); // set -> arrayList
        Collections.sort(sortedList);

        for(int i=0; i< sortedList.size(); i++){
            map.put(sortedList.get(i), i);
        }

        for (int i : origin) {
            sb.append(map.get(i)).append(" ");
        }

        System.out.println(sb);
        br.close();
    }
}
