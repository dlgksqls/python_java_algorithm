import java.util.*;

public class Solution {

    static HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    static int MAX_VALUE = 300;
    static int[][] array = new int[MAX_VALUE+1][MAX_VALUE+1];
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        init();

        for(int tc = 1; tc <= T; tc++) {
            int p = sc.nextInt();
            int q = sc.nextInt();

            Node a = map.get(p);
            Node b = map.get(q);

            int find_y = a.y + b.y;
            int find_x = a.x + b.x;

            System.out.println("#" + tc + " " + array[find_y][find_x]);
        }
    }

    private static void init() {
        int k = 1;
        array[1][1] = 1;
        map.put(1, new Node(1, 1));

        // 세로줄 초기화
        for(int i=2; i<=MAX_VALUE; i++){
            array[i][1] = array[i-1][1] + k;
            map.put(array[i][1], new Node(1, i));
            k++;
        }

        // 가로줄 초기화
        k = 1;
        for(int i=1; i<=MAX_VALUE; i++){
            for(int j=2; j<=MAX_VALUE; j++){
                array[i][j] = array[i][j-1] + (j + k - 1);
                map.put(array[i][j], new Node(j, i));
            }
            k ++; // y축 업데이트
        }
    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
