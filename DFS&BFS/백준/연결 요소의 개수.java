// https://www.acmicpc.net/problem/11724
// 실버2
import java.io.*;
import java.util.*;

class Main{
    // 문제에서 주어진 N의 최댓값에 10개정도 여유
    final static int MAX = 1000 + 10;
    static boolean graph[][];
    static boolean visited[];
    static int N, M;
    static int answer;

    public static void dfs(int idx){
        visited[idx] = true;
        for(int i = 1; i <= N; i++){
            if(visited[i] == false && graph[idx][i]){
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 물론 넉넉하게 [N+1][N+1] 해도 되지만 여유롭게!
        graph = new boolean[MAX][MAX];
        visited = new boolean[MAX];
        int x, y;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }

        // dfs 호출
        for(int i = 1; i <= N; i++){
            if(visited[i] == false){
                answer++;
                dfs(i);
            }
        }

        System.out.println(answer);
    }
}
