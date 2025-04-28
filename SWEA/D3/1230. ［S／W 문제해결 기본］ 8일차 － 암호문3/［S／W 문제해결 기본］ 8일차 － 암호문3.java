import java.util.*;

public class Solution {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {
            int n = sc.nextInt();
            sc.nextLine();
            String pwd = sc.nextLine();
            String[] pwdArray = pwd.split(" ");
            ArrayList<String> n_array = new ArrayList<>(Arrays.asList(pwdArray));

            int order = sc.nextInt();
            sc.nextLine();
            String orderString = sc.nextLine();
            String[] order_arr = orderString.split(" ");

            for(int i=0; i<order_arr.length; i++){
                if (order_arr[i].equals("I")){
                    ArrayList<String> input = new ArrayList<>();
                    for(int j=i+3; j<i+3+Integer.parseInt(order_arr[i+2]); j++){
                        input.add(order_arr[j]);
                    }
                    n_array.addAll(Integer.parseInt(order_arr[i+1]), input);
                }
                else if (order_arr[i].equals("D")){
                    int start = Integer.parseInt(order_arr[i+1]);
                    int end = Integer.parseInt(order_arr[i+2]);
                    for(int j=start+1; j<=start + end; j++){
                        n_array.remove(j);
                    }
                }
                else if (order_arr[i].equals("A")){
                    for(int j=i+2; j<i+2+Integer.parseInt(order_arr[i+1]); j++){
                        n_array.add(order_arr[j]);
                    }
                }
            }

            System.out.print("#" + tc + " ");
            for(int i=0; i<10; i++){
                System.out.print(n_array.get(i) + " ");
            }
            System.out.println();
        }
    }
}
