import java.util.Arrays;
import java.util.Scanner;

/**
 * 세준이는 기말고사를 망쳤다.
 * 세준이는 점수를 조작해서 집에 가져가기로 했다. 일단 세준이는 자기 점수 중에 최댓값을 골랐다. 이 값을 M이라고 한다. 그리고 나서 모든 점수를 점수/M*100으로 고쳤다.
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        float answer = 0;
        float [] arrays = new float[n];

        for (int i=0; i<n; i++){
            arrays[i] = sc.nextInt();
        }

        Arrays.sort(arrays);

        for (float array : arrays) {
            answer += array/arrays[n-1]*100;
        }

        System.out.println(answer/n);
    }
}