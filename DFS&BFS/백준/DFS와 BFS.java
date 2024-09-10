// https://www.acmicpc.net/problem/1260
import java.util.*;
import java.io.*;

class Main{
    static int N, M, V;
    static boolean[][] map;
    static boolean[] visited;
    static ArrayList<Integer> answer;
    static ArrayDeque<Integer> queue;

    static void dfs(int n){
        visited[n] = true;
        answer.add(n);
        for(int i=1; i<=N; i++){
            if(visited[i]==false && map[n][i]){
                dfs(i);
            }
        }
    }

    static void bfs(int n){
        visited[n] = true;
        queue.addLast(n);

        while(!queue.isEmpty()){
            // 가장 앞에 있는 것 꺼내오기
            int idx = queue.pollFirst();
            System.out.print(idx + " ");

            // 꺼낸 애를 기준으로 방문할 수 있는 애를 방문하기.
            for(int i=1; i<=N; i++){
                if(visited[i] == false && map[idx][i]){
                    queue.addLast(i); // 방문한 것은 queue에 계속 붙여준다.
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        // 0.그래프 채우기
        int x, y;
        map = new boolean[N+2][N+2];
        visited = new boolean[N+2];
        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            map[x][y] = true;
            map[y][x] = true;
        }

        answer = new ArrayList<>();
        // 1. V를 시작으로 dfs 방문
        dfs(V);

        for(int n : answer){
            System.out.print(n + " ");
        }

        // 2. BFS으로 방문
        visited = new boolean[N+2];
        queue = new ArrayDeque<>();
        System.out.println("");

        bfs(V);

    }
}
