// https://www.acmicpc.net/problem/2512

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int applyBudgets[] = new int[N];
        for(int n=0; n<N; n++){
            applyBudgets[n] = Integer.parseInt(st.nextToken());
        }


        int totalBudget = Integer.parseInt(br.readLine());

        Arrays.sort(applyBudgets);
        // 이진 탐색 설정
        int left = 0;
        int rigth = applyBudgets[N-1];
        int result = 0;

        while(left <= rigth){
            int mid = (left + rigth) / 2;
            long sum = 0;

            // 예산 요청을 상한액 기준으로 배정
            for(int budget : applyBudgets){
                sum += Math.min(budget, mid);
            }

            // 배정된 예산이 총액보다 작거나 같으면 상한액을 up
            if(sum <= totalBudget){
                result = mid;
                left = mid + 1;
            }else{
                rigth = mid - 1;
            }
        }
        System.out.println(result);
    }
}
