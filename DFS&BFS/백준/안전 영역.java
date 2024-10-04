// https://www.acmicpc.net/problem/2468
import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int safezoneCnt;
    static int[][] map;
    static boolean[][] safezone;
    static boolean[][] visited;
    static int[] moveX = new int[]{-1, 1, 0, 0};
    static int[] moveY = new int[]{0, 0, -1, 1};

    static void dfs(int row, int col) {
        visited[row][col] = true;
        int newX, newY;
        for (int i = 0; i < 4; i++) {
            newX = row + moveX[i];
            newY = col + moveY[i];
            // 범위 체크
            if(newX<0 | newX >=N | newY<0 | newY >=N) continue;

            if (visited[newX][newY] == false && safezone[newX][newY]){
                dfs(newX, newY);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        int maxH = 0;
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                map[n][i] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, map[n][i]);
            }
        }

        int result = 0;
        for(int i=0; i<maxH; i++){
            safezone = new boolean[N][N];
            visited = new boolean[N][N];
            // 1. 침수 안된 부분 체크(true는 침수X)
            for(int row=0; row<N; row++){
                for(int col=0; col<N; col++){
                    safezone[row][col] = map[row][col] > i;
                }
            }

            // 2. 영역 개수 카운트
            safezoneCnt = 0;
            for(int row=0; row<N; row++){
                for(int  col =0; col<N; col++){
                    if(visited[row][col] == false && safezone[row][col]){
                        safezoneCnt++;
                        dfs(row, col);
                    }
                }
            }

            // 3. 안전한 영역 최대 개수
            result = Math.max(safezoneCnt, result);
        }
        System.out.println(result);


    }
}
