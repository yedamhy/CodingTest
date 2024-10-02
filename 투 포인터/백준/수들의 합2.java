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

        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }


        int result = 0;
        // A[i] + ... A[j] = M이 되는 경우 찾기
        for(int i=0; i<N; i++){
            int hap = arr[i];
            if(hap == M){
                result++;
                continue;
            }
            int j=i+1;
            while(hap < M && j<N){
                hap += arr[j];
                if(hap == M){
                    result++;
                    break;
                }
                j++;
            }
        }

        System.out.println(result);

    }
}
