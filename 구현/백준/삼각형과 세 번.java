// https://www.acmicpc.net/problem/5073
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] triangle = new int[3];
            for(int i=0; i<3; i++){
                triangle[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(triangle);

            // 종료 조건
            if(triangle[0] == 0 & triangle[1] == 0 & triangle[2] ==0) break;

            // 1. 삼각형 조건 만족 여부
            if(triangle[0] + triangle[1] <= triangle[2]){
                System.out.println("Invalid");
            }else if(triangle[0] == triangle[1] & triangle[1] == triangle[2]){
                System.out.println("Equilateral");
            }else if(triangle[0] != triangle[1] && triangle[1] != triangle[2] && triangle[2] != triangle[0]) {
                System.out.println("Scalene");
            }else System.out.println("Isosceles");
        }
    }
}
