// [계단 오르기](https://www.acmicpc.net/problem/2579)
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] stairs = new int[N+1];
        int[] dp = new int[N+1];

        for(int n=1; n<=N; n++){
            stairs[n] = Integer.parseInt(br.readLine());
        }

        dp[1] = stairs[1];
        
        if(N==1){
            System.out.println(dp[1]);
            return;
        }
        dp[2] = stairs[1] + stairs[2];
        if(N==2){
            System.out.println(dp[2]);
            return;
        }

        for(int n=3; n<=N; n++){
            dp[n] = Math.max(dp[n-2], dp[n-3]+stairs[n-1]) + stairs[n];
        }

        System.out.println(dp[N]);
    }
}
