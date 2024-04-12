import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 도시의 수 N 입력받기
        int N = sc.nextInt();

        // 각 도로의 길이를 저장할 배열
        long[] roads = new long[N - 1];
        for (int i = 0; i < N - 1; i++) {
            roads[i] = sc.nextLong();
        }

        // 각 도시의 주유소 가격을 저장할 배열
        long[] prices = new long[N];
        for (int i = 0; i < N; i++) {
            prices[i] = sc.nextLong();
        }

        // 최소 비용 계산
        long totalCost = 0;
        long minPrice = prices[0]; // 첫 도시의 주유소 가격을 초기 최소 가격으로 설정

        for (int i = 0; i < N - 1; i++) {
            // 현재 도시의 주유소 가격이 이전까지의 최소 가격보다 작으면 갱신
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            // 현재 도시에서 다음 도시까지 이동하는 데 필요한 비용을 누적 합산
            totalCost += (minPrice * roads[i]);
        }

        System.out.println(totalCost);
        sc.close();
    }
}
