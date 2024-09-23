// https://www.acmicpc.net/problem/9095

import java.io.*;
import java.util.*;

public class Main{
    static int[] dp;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] nums = new int[T];
        for(int i=0; i < T; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        for(int n : nums){
            dp = new int[12];

            // 기저 조건
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            if(n <=3){
                System.out.println(dp[n]);
                continue;
            }
            for(int i=4; i<=n; i++){
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
            System.out.println(dp[n]);
        }



    }
}
