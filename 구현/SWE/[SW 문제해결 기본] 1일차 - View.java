// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV134DPqAA8CFAYh
import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = sc.nextInt();
            int[] buildings = new int[N];
            for (int n = 0; n < N; n++) {
                buildings[n] = sc.nextInt();
            }
            int result = 0;

            // 양쪽 끝 두 칸은 건물이 없으므로, 2 ~ N-3만 확인
            for (int i = 2; i < N - 2; i++) {
                // 주변 4개의 건물 중 가장 높은 값을 찾음
                int maxAround = Math.max(
                    Math.max(buildings[i - 2], buildings[i - 1]),
                    Math.max(buildings[i + 1], buildings[i + 2])
                );

                // 현재 건물이 주변 건물보다 높아야 조망권 확보 가능
                if (buildings[i] > maxAround) {
                    result += buildings[i] - maxAround;
                }
            }

            System.out.println("#" + test_case + " " + result);
        }
    }
}
