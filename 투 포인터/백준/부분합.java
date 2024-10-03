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



        int minLen = Integer.MAX_VALUE;

        for(int left = 0; left < N; left++){
            int hap = 0;
            int right = left;
            while(left <= right && right < N){
                hap += arr[right];

                if(hap >= S){
                    minLen = Math.min(minLen, right - left + 1);
                    break;
                }else right++;

                if(right-left+1 > minLen) break;
            }
        }
        if(minLen == Integer.MAX_VALUE) minLen = 0;

        System.out.println(minLen);

    }
}
