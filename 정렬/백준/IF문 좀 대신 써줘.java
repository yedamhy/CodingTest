// https://www.acmicpc.net/problem/19637
import java.util.*;
import java.io.*;

public class Main{
    static int[] power;
    public static int binarySearch(int target){
        int low = 0;
        int high = power.length-1;

        while(low < high){
            int mid = (low + high) / 2;

            if(power[mid] >= target) high = mid;
            else low = mid + 1;
        }

        return high; // 못찾으면
    }
    public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine());

         int N = Integer.parseInt(st.nextToken());
         int M = Integer.parseInt(st.nextToken());

         // 1. 전투력 기준, 상호 입력받기
        power = new int[N];
        String[] nickname = new String[N];
         for(int n=0; n<N; n++){
             st = new StringTokenizer(br.readLine());
             nickname[n] = st.nextToken();
             power[n] = Integer.parseInt(st.nextToken());
         }

         // 2. 전투력 입력 받고 칭호 출력
        for(int m=0; m<M; m++){
            int input = Integer.parseInt(br.readLine());
            int result = binarySearch(input);
            System.out.println(nickname[result]);
        }


    }
}
