import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    static int true_number;
    static int[] true_person;
    static ArrayList<Integer>[] party;
    static int[] check;
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        true_number = sc.nextInt();
        true_person = new int[true_number];
        for (int i=0; i<true_number; i++){
            true_person[i] = sc.nextInt();
        }

        party = new ArrayList[m];
        for (int i=0; i<m; i++){
            party[i] = new ArrayList<>();
            int party_size = sc.nextInt();
            for (int j=0; j<party_size; j++){
                party[i].add(sc.nextInt());
            }
        }
        check = new int[n+1];
        for (int i=0; i<=n; i++){
            check[i] = i;
        }

        for (int i=0; i<m; i++){
            int firstPeople = party[i].get(0);
            for (int j=1; j<party[i].size(); j++){
                union(firstPeople, party[i].get(j));
            }
        }

        for (int i=0; i<m; i++){
            boolean isPossible = true;
            int cur = party[i].get(0);
            for (int j=0; j<true_person.length; j++){
                if (find(cur) == find(true_person[j])){
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) result ++;
        }
        System.out.println(result);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b){
            check[b] = a;
        }
    }

    private static int find(int i) {
        if (i == check[i]){
            return i;
        }
        return check[i] = find(check[i]);
    }
}
