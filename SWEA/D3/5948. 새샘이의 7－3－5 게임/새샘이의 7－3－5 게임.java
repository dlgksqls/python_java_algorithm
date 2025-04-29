import java.util.*;

public class Solution {

    static Integer[] array;
    static TreeSet<Integer> treeSet;
    static int answer;
    static int choose;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            array = new Integer[7];
            choose = 0;

            for(int i=0; i<7; i++){
                array[i] = sc.nextInt();
            }

            treeSet = new TreeSet<>();
            Arrays.sort(array, Collections.reverseOrder());

            recursion(0, 0, 0);

            for(int i=0; i<5; i++){
                answer = treeSet.pollLast();
            }

            System.out.println("#" + tc + " " + answer);
        }
    }

    private static void recursion(int idx, int depth, int sum) {
        if (depth == 3){
            treeSet.add(sum);
            return;
        }

        if (idx >= 7) return;

        recursion(idx + 1, depth + 1, sum + array[idx]);

        recursion(idx + 1, depth, sum);
    }
}
