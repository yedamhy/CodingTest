// https://www.acmicpc.net/problem/9655
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] dp = new String[N+1];
        dp[1] = "SK";
        if(N >= 2) dp[2] = "CY"; // 돌이 2개일 때는 창영이가 승리
        if(N >= 3) dp[3] = "SK"; // 돌이 3개 일때는 상근이가 승리

        for(int i=4; i<=N; i++){
            // 상근이가 이기려면? dp[i-1] 또는 dp[i-3]이 창영이가 가져갔어야 함
            if(dp[i-3].equals("CY") | dp[i-1].equals("CY")) dp[i] = "SK";
            else dp[i] = "CY";
        }

        System.out.println(dp[N]);
    }
}
