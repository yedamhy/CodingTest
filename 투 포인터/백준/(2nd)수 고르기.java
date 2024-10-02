// https://www.acmicpc.net/problem/2003

import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }


        Arrays.sort(arr);

        int i=0;
        int j=0;
        int minDiff = Integer.MAX_VALUE;

        // 투 포인터로 차이를 구함
        while(j < N){
            int diff = arr[j] - arr[i];
            if(diff >= M){
                minDiff = Math.min(minDiff, diff);
                i++;
            }else{
                j++;
            }

            if (i == j) {
                j++;
            }

        }

        System.out.println(minDiff);
    }
}
