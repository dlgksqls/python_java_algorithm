/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int[][] board = new int[9][9];

            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            int answer = 1;

            // 1. 행 체크
            for(int i = 0; i < 9; i++) {
                Set<Integer> set = new HashSet<>();
                for(int j = 0; j < 9; j++) {
                    set.add(board[i][j]);
                }
                if(set.size() != 9) answer = 0;
            }

            // 2. 열 체크
            for(int j = 0; j < 9; j++) {
                Set<Integer> set = new HashSet<>();
                for(int i = 0; i < 9; i++) {
                    set.add(board[i][j]);
                }
                if(set.size() != 9) answer = 0;
            }

            // 3. 3x3 박스 체크
            for(int r = 0; r < 9; r += 3) {
                for(int c = 0; c < 9; c += 3) {
                    Set<Integer> set = new HashSet<>();
                    for(int i = r; i < r + 3; i++) {
                        for(int j = c; j < c + 3; j++) {
                            set.add(board[i][j]);
                        }
                    }
                    if(set.size() != 9) answer = 0;
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}