import java.util.*;

public class Solution {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for(int i=0; i<n; i++){
                array[i] = sc.nextInt();
            }

            int answer = -1;

            for(int i=0; i<n-1; i++){
                for(int j=i+1; j<n; j++){
                    int num = array[i] * array[j];
                    String arr_string = String.valueOf(num);
                    boolean flag = true;
                    if (arr_string.length() > 1){
                        for(int k=0; k<arr_string.length()-1; k++){
                            for(int l=k+1; l<arr_string.length(); l++){
                                if (arr_string.charAt(k) - '0' > arr_string.charAt(l) - '0') {
                                    flag = false;
                                    break;
                                }
                            }
                            if (!flag) break;
                        }
                    }
                    if (flag){
                        answer = Math.max(answer, Integer.parseInt(arr_string));
                    }
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}
