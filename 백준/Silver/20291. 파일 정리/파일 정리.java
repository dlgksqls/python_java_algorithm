import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static String[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        array = new String[n];
        ArrayList<String> files = new ArrayList<>();

        for (int i=0; i<n; i++){
            array[i] = br.readLine();
        }

        for (int i = 0; i < array.length; i++) {
            String[] split = array[i].split("\\.");
            String key = split[1];

            if (map.get(key) == null) {
                map.put(key, 1);
                files.add(key);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }

        Collections.sort(files);

        for (String file : files) {
            System.out.println(file + " " + map.get(file));
        }

        br.close();
    }
}
