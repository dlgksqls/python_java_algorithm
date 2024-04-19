import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int cnt = 0; // M 갯수 카운팅
        boolean flag = false; // M이 나왔는가?

        String max = maxNum(sb, cnt, flag, input);
        String min = minNum(sb2, cnt, flag, input);

        System.out.println(max);
        System.out.println(min);

        br.close();
    }

    public static String maxNum(StringBuilder sb, int cnt, boolean flag, String input){
        for (int i=0; i<input.length(); i++){
            if (!flag && input.charAt(i) == 'K')
                sb.append(5);
            if (input.charAt(i) == 'M') {
                flag = true;
                cnt++;
            }
            else if (flag && input.charAt(i) == 'K'){
                sb.append(5).append("0".repeat(cnt));
                flag = false;
                cnt = 0;
            }
        }
        if (cnt != 0)
            sb.append("1".repeat(cnt));
        return sb.toString();
    }
    public static String minNum(StringBuilder sb, int cnt, boolean flag, String input){
        for (int i=0; i<input.length(); i++){
            if (!flag && input.charAt(i) == 'K')
                sb.append(5);
            if (input.charAt(i) == 'M') {
                flag = true;
                cnt++;
            }
            else if(flag && input.charAt(i) == 'K'){
                sb.append(1).append("0".repeat(cnt-1));
                sb.append(5);
                flag = false;
                cnt = 0;
            }
        }
        if (cnt != 0){
            sb.append(1).append("0".repeat(cnt-1));
        }
        return sb.toString();
    }
}
