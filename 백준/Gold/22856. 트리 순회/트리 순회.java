import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int value;
        int left;
        int right;

        public Node(int value, int left, int right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    static Node[] tree;
    static int last = -1;
    static int move = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        tree = new Node[n+1];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            tree[v] = new Node(v, l, r);
        }

        inorder(1);
        int depth = findDepth(1, 0);

        System.out.println(move - depth);

        br.close();
    }

    private static void inorder(int current) {
        if (current == -1) return;

        if (tree[current].left != -1){
            move ++;
            inorder(tree[current].left);
            move ++;
        }
        last = current;
        if (tree[current].right != -1){
            move ++;
            inorder(tree[current].right);
            move ++;
        }
    }

    private static int findDepth(int current, int depth) {
        if (current == -1) return -1;
        if (current == last) return depth;

        int left = findDepth(tree[current].left, depth + 1);
        return findDepth(tree[current].right, depth + 1);
    }
}
