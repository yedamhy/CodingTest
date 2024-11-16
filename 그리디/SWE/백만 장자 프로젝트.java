// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LrsUaDxcDFAXc
import java.util.Scanner;
 
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
 
        // 테스트 케이스 수 입력
        int T = sc.nextInt();
 
        for (int test_case = 1; test_case <= T; test_case++) {
            // 배열의 크기 입력
            int N = sc.nextInt();
 
            // 배열 입력
            int[] prices = new int[N];
            for (int i = 0; i < N; i++) {
                prices[i] = sc.nextInt();
            }
 
            // 최대 이익 계산
            long profit = calculateProfit(prices, N);
 
            // 결과 출력
            System.out.println("#" + test_case + " " + profit);
        }
    }
 
    // 최대 이익 계산 메소드
    static long calculateProfit(int[] prices, int N) {
        int maxPrice = 0;
        long profit = 0;
 
        // 뒤에서부터 탐색하며 최대값 업데이트
        for (int i = N - 1; i >= 0; i--) {
            if (prices[i] > maxPrice) {
                maxPrice = prices[i];
            } else {
                profit += (maxPrice - prices[i]);
            }
        }
 
        return profit;
    }
}
