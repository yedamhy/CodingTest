// https://www.acmicpc.net/problem/13565
// 실버2
import java.util.*;
import java.io.*;

class Main{
    static int N, M;
    static boolean[][] map;
    static boolean[][] visited;
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};

    static void dfs(int y, int x){
        visited[y][x] = true;

        for(int i=0; i<4; i++){
            int dirX = x + moveX[i];
            int dirY = y + moveY[i];

            if(visited[dirY][dirX] == false && map[dirY][dirX]){
                dfs(dirY, dirX);
            }
        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        // 1. map 채우기
        map = new boolean[M+2][N+2];
        visited = new boolean[M+2][N+2];
        for(int i = 1; i <= M; i++){
            String str = br.readLine();
            for(int j=1; j<=N; j++){
                map[i][j] = (str.charAt(j-1) == '0');
                // 위에게 헷갈리면 map[i][j] = (str.charAt(j-1) == '0') ? true : false;
            }
        }

        // 2. dfs 수행
        for(int i = 1; i<= N; i++){
            if(map[1][i] && visited[1][i]==false){
                dfs(1, i);
            }
        }
        // 3. 결과 출력
        int answer = 0;
        for(int i=1; i<=N; i++){
            if(visited[M][i]){
                answer++;
            }
        }

        if(answer == 0){
            System.out.println("NO");
        } else{
            System.out.println("YES");
        }
    }
}
