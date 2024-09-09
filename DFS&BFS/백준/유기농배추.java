// https://www.acmicpc.net/problem/1012
// 실버2
import java.util.*;
import java.io.*;

class Main{
    final static int MAX = 50 + 10;
    static int T, N, M, K;
    static boolean map[][];
    static boolean visited[][];
    static int[] dirY = {-1, 1, 0, 0};
    static int[] dirX = {0, 0, -1, 1};

    static void dfs(int y, int x){
        visited[y][x] = true;
        //dfs(y+1, x);
        //dfs(y-1, x);
        //dfs(y, x+1);
        //dfs(y, x-1);
        for(int i = 0; i < 4; i++) {
            int newY = y + dirY[i];
            int newX = x + dirX[i];
            if(map[newY][newX] && visited[newY][newX] == false){
                dfs(newY, newX);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while(T --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            // 1. map 채우기
            map = new boolean[MAX][MAX];
            visited = new boolean[MAX][MAX];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y + 1][x + 1] = true;
            }

            // 2. dfs 수행
            int answer = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (map[i][j] && visited[i][j] == false) {
                        answer++;
                        dfs(i, j);
                    }
                }
            }

            // 3, 출력
            System.out.println(answer);
        }
    }
}
