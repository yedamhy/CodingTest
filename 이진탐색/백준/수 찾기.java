// https://www.acmicpc.net/problem/1920

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            input[n] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] output = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int m=0; m<M; m++){
            output[m] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);

        int[] result = new int[M];
        for(int m=0; m<M; m++){
            int left = 0;
            int rigth = N-1;

            int target = output[m];
            while(left <= rigth){
                int mid = (left + rigth) / 2;

                if(target == input[mid]){
                    result[m] = 1;
                    break;
                }else if(target < input[mid]){
                    rigth = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            System.out.println(result[m]);
        }

    }
}
