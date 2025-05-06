import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            char[] x = st.nextToken().toCharArray();
            
            long sum = 0;
            for(char c : x) {
                sum += c - '0';
            }
            
            System.out.println("#" + tc + " " + sum % (n - 1));
        }
    }
}