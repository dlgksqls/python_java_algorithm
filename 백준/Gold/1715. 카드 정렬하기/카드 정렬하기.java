import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    static int n;

    static PriorityQueue<Integer> queue = new PriorityQueue<>();
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++){
            queue.add(Integer.parseInt(br.readLine()));
        }

        while (queue.size() > 1){
            int a = queue.poll();
            int b = queue.poll();

            answer += (a+b);
            queue.add(a+b);
        }
        System.out.println(answer);
    }
}
