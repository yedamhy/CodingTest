// https://www.acmicpc.net/problem/2096
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // DP 배열: 현재와 이전 행만 유지
        int[] prevMax = new int[5];
        int[] currMax = new int[5];
        int[] prevMin = new int[N + 2];
        int[] currMin = new int[N + 2];

        prevMin[0] = Integer.MAX_VALUE;
        prevMin[N+1] = Integer.MAX_VALUE;

        currMin[0] = Integer.MAX_VALUE;
        currMin[N+1] = Integer.MAX_VALUE;

        // 첫 번째 줄 입력 처리 및 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 1; j <= N; j++) {
            int val = Integer.parseInt(st.nextToken());
            prevMax[j] = val;
            prevMin[j] = val;
        }

        // 나머지 줄 처리
        for (int i = 2; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                int val = Integer.parseInt(st.nextToken());

                // 최대값 계산
                currMax[j] = val + Math.max(Math.max(prevMax[j - 1], prevMax[j]), prevMax[j + 1]);

                // 최소값 계산
                currMin[j] = val + Math.min(Math.min(prevMin[j - 1], prevMin[j]), prevMin[j + 1]);
            }

            // 현재 행을 이전 행으로 복사
            System.arraycopy(currMax, 0, prevMax, 0, N + 2);
            System.arraycopy(currMin, 0, prevMin, 0, N + 2);
        }

        // 최댓값과 최솟값 찾기
        int max = Arrays.stream(prevMax).max().getAsInt();
        int min = Arrays.stream(prevMin).min().getAsInt();

        // 결과 출력
        System.out.println(max + " " + min);
    }
}
