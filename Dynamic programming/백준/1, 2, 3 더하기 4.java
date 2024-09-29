// https://www.acmicpc.net/problem/15989
import java.util.*;
import java.io.*;

public class Main{
    static int[] hap;
    static int[] hap23;
    static void makeTwoThree(int max){
        hap23 = new int[max+1];
        for(int i=1; i<=max/2; i++){
            for(int j=1; j<= max/3; j++){
                if(2*i + 3*j > max) break;
                hap23[2*i+3*j] += 1;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] input = new int[T];
        int max = 0;
        for(int t=0; t<T; t++){
            input[t] = Integer.parseInt(br.readLine());
            max = Math.max(max, input[t]);
        }

        makeTwoThree(max);

        hap = new int[max+1];
        hap[1] = 1; hap[2] = 2; hap[3] = 3;

        for(int i=4; i<=max; i++){
            //1. 전 단계에서 +1 한거 합하기
            hap[i] += hap[i-1];

            // 2-1. 2로 나누어 떨어지는 것
            if(i % 2 == 0) hap[i]++;

            // 2-2. 3으로 나누어 떨어지는 것
            if(i%3 == 0) hap[i]++;

            hap[i] += hap23[i];
        }

        for(int t=0; t<T; t++){
            System.out.println(hap[input[t]]);
        }
    }
}
