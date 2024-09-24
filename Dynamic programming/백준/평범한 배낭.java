// https://www.acmicpc.net/problem/12865
import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  // 물건의 개수
        int K = Integer.parseInt(st.nextToken());  // 배낭의 최대 무게

        dp = new int[N + 1][K + 1];  // DP 테이블 초기화

        int[] weight = new int[N + 1];
        int[] value = new int[N + 1];

        // 물건의 무게와 가치를 입력 받음
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        // DP 계산
        for (int i = 1; i <= N; i++) {
            for (int w = 0; w <= K; w++) {
                if (weight[i] <= w) {
                    // 물건을 넣을 수 있는 경우
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weight[i]] + value[i]);
                } else {
                    // 물건을 넣을 수 없는 경우 (이전 값 그대로)
                    dp[i][w] = dp[i - 1][w];
                }



            }


        }

        // 최종 결과 출력
        System.out.println(dp[N][K]);
    }
}


