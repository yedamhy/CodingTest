// https://www.acmicpc.net/problem/1806
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }


        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for(int right =0; right < N; right++){
            sum += arr[right];
            
            // 부분합이 S이상이면, left를 늘려서 최소 구간 찾기
            while(sum >= S){
                minLen = Math.min(minLen, right - left + 1);
                sum -= arr[left];
                left++;
                 
            }
        }
        
        if(minLen == Integer.MAX_VALUE) minLen = 0;

        System.out.println(minLen);

    }
}
