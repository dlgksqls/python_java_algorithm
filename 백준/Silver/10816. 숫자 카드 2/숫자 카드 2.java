import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }

        Arrays.sort(array);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int findNum = Integer.parseInt(st.nextToken());
//            int start = 0;
//            int end = n - 1;
//            boolean flag = false;
//
//            while(start <= end){
//                int mid = (start + end) / 2;
//                if (findNum == array[mid]){
//                    flag = true;
//                    break;
//                }
//
//                if (findNum < array[mid]){
//                    end = mid - 1;
//                }
//                else if (findNum > array[mid]){
//                    start = mid + 1;
//                }
//            }

            if (!map.containsKey(findNum)) sb.append(0 + " ");
            else sb.append(map.get(findNum) + " ");
        }

        System.out.println(sb);
        br.close();
    }
}
