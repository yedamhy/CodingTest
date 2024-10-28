//https://www.acmicpc.net/problem/1072
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        if(X == Y){
            System.out.println(-1);
            return;
        }

        // 이분탐색 하다가 처음 계산한거랑 변화가 생기는 지점!
        // 주의! 변화 시점을 찾아야 함. 내림을 하고 있기에 찾은 값이 최솟값이 아닐 수도 있음
        int min = 1;
        int max = X;

        int firstZ = calZ(X, Y);

        // 99%는 100%가 되지 못함
        if(firstZ == 99){
            System.out.println(-1);
            return;
        }

        while(min <= max){
            int mid = (min + max) / 2;
            int nowZ = calZ(X+mid, Y+mid);
            if(nowZ >= firstZ + 1){
                max = mid - 1;
            }else{
                min = mid + 1;
            }

            // System.out.println("min = " + min+" max = " + max + "  nowZ = " + nowZ);
        }

        System.out.println(min);
    }

    static int calZ(int x, int y){
        return (int)( y  * 100.0 / x);
    }
}
