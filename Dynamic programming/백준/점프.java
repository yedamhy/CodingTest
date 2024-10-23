// https://www.acmicpc.net/problem/1890
import java.util.*;
import java.io.*;

class Main{
    static int[][] gameArea;
    static long[][] memo;
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        gameArea = new int[N+1][N+1];
        memo = new long[N+1][N+1];
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                gameArea[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long r = dfs(1, 1);
        System.out.println(r);
    }

    static long dfs(int x, int y){
        if(x==N && y==N) return 1;
        if(memo[x][y] > 0){
            return memo[x][y];
        }

        int step = gameArea[x][y];
        if(step == 0) return 0;

        //오른쪽으로 이동
        if(y+step <=N){
            memo[x][y] += dfs(x, y+step);
        }

        // 아래로 이동
        if(x+step<=N){
            memo[x][y] += dfs(x+step, y);
        }

        return memo[x][y];
    }
}
