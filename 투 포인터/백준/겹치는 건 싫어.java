// https://www.acmicpc.net/problem/20922
import java.util.*;
import java.io.*;

public class Main{
    static int N, K;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 투 포인터와 슬라이딩 윈도우를 위한 자료구조
        int[] count = new int[100001];
        int start = 0, end = 0;
        int maxLength = 0;

        while(end < N){
            // 현재 수의 등장 횟수를 증가시킴
            count[arr[end]]++;

            while(count[arr[end]] > K){
                count[arr[start]]--;
                start++; // 윈도우 시작지점 이동
            }

            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }

        System.out.println(maxLength);
    }
}
