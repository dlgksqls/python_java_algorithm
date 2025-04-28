import java.util.*;

public class Solution {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {
            int n = sc.nextInt();
            sc.nextLine();
            String pwd = sc.nextLine();
            String[] pwdArray = pwd.split(" ");
            List<String> pwdList = new ArrayList<>(Arrays.asList(pwdArray));

            int m = sc.nextInt();
            sc.nextLine();
            String cmd = sc.nextLine();
            String[] array = cmd.split("I ");

            for (String current : array) {
                if (current.trim().isEmpty()) continue;

                String[] split = current.split(" ");
                int x = Integer.parseInt(split[0]);
                int y = Integer.parseInt(split[1]);

                List<String> toInsert = new ArrayList<>();
                for(int i = 0; i < y; i++) {
                    toInsert.add(split[i+2]);
                }
                pwdList.addAll(x, toInsert);
            }

            System.out.print("#" + tc + " ");
            for(int i=0; i<10; i++){
                System.out.print(pwdList.get(i) + " ");
            }
            System.out.println();
        }
    }
}
