// https://www.acmicpc.net/problem/14719

import java.io.*;
import java.util.*;

public class Main{
    static int H, W;
    static boolean[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new boolean[H][W];
        st = new StringTokenizer(br.readLine());
        for(int w=0; w<W; w++) {
            int blockH = Integer.parseInt(st.nextToken());
            for (int h = H - 1; h >= H - blockH; h--) {
                map[h][w] = true;
            }
        }
        int result = 0;
        for(int i = H-1; i>=0; i--){
            int rowStart = -1;
            int rowCnt = 0; // 각 줄에서 true에서부터 다음 true를 만날때까지 카운트
            for(int j=0; j<W; j++){
                if(map[i][j] & rowStart == -1) rowStart = j;
                else if(map[i][j] & rowStart >=0){
                    rowCnt += j-rowStart-1;
                    rowStart = j;
                }
            }

            result += rowCnt;
        }

        System.out.println(result);
    }
}
