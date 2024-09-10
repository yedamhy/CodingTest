// https://www.acmicpc.net/problem/2644
import java.util.*;
import java.io.*;

class Main{
    static int N, M, person1, person2, answer;
    static boolean[][] graph;
    static boolean[] visited;

    static void dfs(int n, int count){
        visited[n] = true;
        if(n == person2){
            answer = count;
            return;
        }

        for(int i=1; i<=N; i++){
            if(visited[i] == false && graph[n][i]){
                dfs(i, count+1);
            }
        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        person1 = Integer.parseInt(st.nextToken());
        person2 = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        graph = new boolean[N+2][N+2];
        // 0. 그래프 채우기
        int x, y;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }

        // 여기서 count가 재귀함수 dfs의 depth 역할을 함.
        // person1을 기준으로 시작
        dfs(person1, 0);

        if(answer == 0) answer = -1;
        System.out.println(answer);
    }
}
