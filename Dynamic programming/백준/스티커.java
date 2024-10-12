// [스티커](https://www.acmicpc.net/problem/9465)
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][N+1];
            int[][] dp = new int[2][N+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int n=1; n<=N; n++){
                sticker[0][n] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int n=1; n<=N; n++){
                sticker[1][n] = Integer.parseInt(st.nextToken());
            }

            // 초기값 설정
            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];

            // DP 계산
            for(int i=2; i<=N; i++){
                dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + sticker[1][i];
            }


            System.out.println(Math.max(dp[0][N], dp[1][N]));
        }

    }
}
