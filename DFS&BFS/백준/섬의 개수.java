// https://www.acmicpc.net/problem/4963
// 실버2
import java.util.*;
import java.io.*;

class Main{
    static int w, h;
    static boolean[][] map;
    static boolean[][] visited;
    static int cnt;
    static int[] dirX = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] dirY = {-1, -1, -1, 0, 0, 1, 1, 1};

    static void dfs(int y, int x){
        visited[y][x] = true;
        for(int i=0; i<8; i++){
            int nowX = x+dirX[i];
            int nowY = y+dirY[i];

            if(visited[nowY][nowX]==false && map[nowY][nowX]){
                dfs(nowY, nowX);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            // 프로그램 종료되는 조건
            if(w == 0 && h == 0) break;

            map = new boolean[h+2][w+2];
            visited = new boolean[h+2][w+2];

            // 1. map 채우기
            for(int i=1; i<=h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken()) == 1;
                }
            }

            // 2. dfs 실행
            cnt = 0;
            for(int i=1; i<=h; i++){
                for(int j=1; j<=w; j++){
                    if(visited[i][j]==false && map[i][j]){
                        cnt++;
                        dfs(i, j);
                    }
                }
            }

            System.out.println(cnt);

        }
    }
}
