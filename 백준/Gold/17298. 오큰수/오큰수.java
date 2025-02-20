import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        int[] answer = new int[n];
        int output;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> myStack = new Stack<>();
        myStack.push(0);

        for (int i=1; i<n; i++){
            while (!myStack.isEmpty() && array[myStack.peek()] < array[i]){
                answer[myStack.pop()] = array[i];
            }
            myStack.push(i);
        }

        while (!myStack.isEmpty()){
            output = myStack.pop();
            answer[output] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i=0; i<n; i++){
            bw.write(answer[i] + " ");
        }

//        for (int i : answer) {
//            System.out.print(i + " ");
//        }
        
        bw.write("\n");
        bw.flush();
        br.close();
    }
}
