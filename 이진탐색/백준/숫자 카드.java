// https://www.acmicpc.net/problem/10815

import java.io.*;
import java.util.*;

public class Main{
    static int H, W;
    static boolean[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] sang = new int[N];
        for(int n=0; n<N; n++){
            sang[n] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sang);

        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int m=0; m<M; m++){
            arr[m] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[M];

        // 이진탐색
        for(int m=0; m<M; m++){
            int target = arr[m];
            int left = 0;
            int rigth = N-1;

            while(left <= rigth){
                int mid = (left + rigth) / 2;

                if(target == sang[mid]) {
                    result[m] = 1;
                    break;
                }
                else if(target < sang[mid]) rigth = mid -1;
                else left = mid + 1;
            }
        }

        for(int r : result){
            System.out.print(r + " ");
        }
    }
}
