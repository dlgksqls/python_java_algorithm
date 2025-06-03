import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] array = new int[9];
        for(int i=0; i<9; i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        for(int a=0; a<=2; a++){
            int idx = 0;
            int sum = 0;
            int[] answer = new int[7];
            answer[idx++] = array[a];
            for(int b=a+1; b<=3; b++){
                answer[idx++] = array[b];
                for(int c=b+1; c<=4; c++){
                    answer[idx++] = array[c];
                    for(int d=c+1; d<=5; d++){
                        answer[idx++] = array[d];
                        for(int e=d+1; e<=6; e++){
                            answer[idx++] = array[e];
                            for(int f=e+1; f<=7; f++){
                                answer[idx++] = array[f];
                                for(int g=f+1; g<=8; g++){
                                    answer[idx++] = array[g];
                                    sum = array[a] + array[b] + array[c] + array[d] + array[e] + array[f] + array[g];
                                    if (sum == 100) {
                                        for (int i : answer) {
                                            System.out.println(i);
                                        }
                                        return;
                                    }
                                    idx --;
                                }
                                idx --;
                            }
                            idx --;
                        }
                        idx --;
                    }
                    idx --;
                }
                idx --;
            }
        }
    }
}
