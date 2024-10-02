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

        int min = Integer.MAX_VALUE;

        Arrays.sort(arr);

        for(int i=0; i<N-1; i++){
            int j = i+1;
            int diff = Math.abs(arr[j] - arr[i]);
            if(diff == M){
                min = diff;
                break;
            }

            if(diff > M) min = Math.min(diff, min);

            while(diff <= M && j < N){
                diff = Math.abs(arr[j]- arr[i]);

                if(diff == M){
                    System.out.println(M);
                    return;
                }else if(diff < M){
                    j++;
                }
                else{
                    min = Math.min(diff, min);
                    break;
                }
            }
        }

        System.out.println(min);
    }
}
