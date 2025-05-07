import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static class Node{
        char data;
        int left;
        int right;
        public Node(char data, int left, int right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static Node[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int tc = 1; tc <= 10; tc ++){
            int n = Integer.parseInt(br.readLine());
            tree = new Node[n + 1];
            for(int i=1; i<=n; i++){
                st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                char data = st.nextToken().charAt(0);
                int left = 0;
                int right = 0;
                if (st.hasMoreTokens()) left = Integer.parseInt(st.nextToken());
                if (st.hasMoreTokens()) right = Integer.parseInt(st.nextToken());

                tree[idx] = new Node(data, left, right);
            }

            System.out.print("#" + tc + " ");
            inorder(1);
            System.out.println();
        }

        br.close();
    }

    private static void inorder(int idx) {
        if (idx == 0) return;
        inorder(tree[idx].left);
        System.out.print(tree[idx].data);
        inorder(tree[idx].right);
    }
}
