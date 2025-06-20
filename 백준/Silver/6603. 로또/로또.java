import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> arrayList;
    static boolean[] visited;
    static int[] array;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            array = new int[k];
            for(int i=0; i<k; i++){
                array[i] = Integer.parseInt(st.nextToken());
            }

            arrayList = new ArrayList<>();
            visited = new boolean[k];

            recursion(0);
            System.out.println();
        }
        br.close();
    }

    private static void recursion(int idx) {
        if (arrayList.size() == 6){
            for (Integer i : arrayList) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i=idx; i<array.length; i++){
            if (!visited[i]) {
                visited[i] = true;
                arrayList.add(array[i]);
                recursion(i + 1);
                arrayList.remove(arrayList.size() - 1);
                visited[i] = false;
            }
        }
    }
}
