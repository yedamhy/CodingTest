// https://www.acmicpc.net/problem/11058
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N+3];
        dp[1] = 1; dp[2] = 2; dp[3] = 3;
        if(N<4){
            System.out.println(dp[N]);
            return;
        }
        for(int i=4; i<=N; i++){
            dp[i] = dp[i-1]+1;

            // CtrlA - CtrlC - CtrlV 쓸 타이밍 찾기
            for(int j=1; j< i-2; j++){
                dp[i] = Math.max(dp[i], dp[j]*(i-j-1));
            }

        }

        System.out.println(dp[N]);
    }
}
