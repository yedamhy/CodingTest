// https://www.acmicpc.net/problem/14501
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+2];
        int[] T = new int[N+1];
        int[] P = new int[N+1];


        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i+1] = Integer.parseInt(st.nextToken());
            P[i+1] = Integer.parseInt(st.nextToken());
        }

        for(int i=N; i>0; i--){
            // 상담 시간이 7일차를 over하게 되는지 먼저 확인!
            if(i + T[i] - 1 > N) dp[i] = dp[i+1];
            else{
                dp[i] = Math.max(dp[i+1], P[i] + dp[i+T[i]]);
            }

        }
        

        // 최종 결과 출력\
        System.out.println(dp[1]);
    }
}


