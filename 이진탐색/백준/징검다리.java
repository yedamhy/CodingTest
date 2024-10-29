// https://www.acmicpc.net/problem/11561
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            long N = Long.parseLong(br.readLine());
            findJumpMax(N);
        }
    }

    static void findJumpMax(long n){
        long left = 1;
        long right = (long) Math.sqrt(2 * n) + 1;
        long result = 0;
        while(left <= right){
            long mid = (left + right) / 2;
            long sum = mid*(mid+1)/2;

            if (sum <= n) {
                result = mid;  // 조건을 만족하는 최대 mid 저장
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}
