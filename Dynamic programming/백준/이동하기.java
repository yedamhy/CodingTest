//https://www.acmicpc.net/problem/11048
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] maze = new int[N+2][M+2];
        long[][] candy = new long[N+2][M+2];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                candy[i][j] = maze[i][j] + Math.max(Math.max(candy[i-1][j], candy[i][j-1]), candy[i-1][j-1]);
            }
        }

        System.out.println(candy[N][M]);
    }
}
