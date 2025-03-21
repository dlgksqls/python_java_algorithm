import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static class NumberIndex{
        int x;
        int y;

        public NumberIndex(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static char input1;
    static char input2;
    static int count = 0;
    static String input_string;
    static char[][] array = {
            {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
            {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'},
            {'z', 'x', 'c', 'v', 'b', 'n', 'm'}
    };
    static String leftHandKeys = "qwertasdfgzxcv";
    static int left_x ;
    static int left_y ;
    static int right_x;
    static int right_y;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        input1 = sc.next().charAt(0);
        input2 = sc.next().charAt(0);

        input_string = sc.next();

         NumberIndex first_left = findChar(input1);
         NumberIndex first_right= findChar(input2);
         left_x = first_left.x;
         left_y = first_left.y;

         right_x = first_right.x;
         right_y = first_right.y;

        for(char c : input_string.toCharArray()){
            NumberIndex newNumber = findChar(c);
            cal(newNumber.x, newNumber.y, c);
        }

        System.out.println(count);
        sc.close();
    }

    private static void cal(int number_x, int number_y, char c) {
        if (leftHandKeys.indexOf(c) != -1){
            count += Math.abs(left_x - number_x) + Math.abs(left_y - number_y);
            left_x = number_x;
            left_y = number_y;
        }
        else{
            count += Math.abs(right_x - number_x) + Math.abs(right_y - number_y);
            right_x = number_x;
            right_y = number_y;
        }
        count ++;
    }

    private static NumberIndex findChar(char c) {
        for (int i=0; i< array.length; i++){
            for (int j=0; j<array[i].length; j++){
                if (array[i][j] == c) return new NumberIndex(i, j);
            }
        }
        return null;
    }
}
