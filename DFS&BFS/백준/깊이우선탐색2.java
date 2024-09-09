// https://www.acmicpc.net/problem/24480
// 실버2

import java.util.*;
import java.io.*;

class Main{

    static int N, M, R;
    static ArrayList<Integer>[] graph;
    static int[] visited;
    static int now = 1;

    public static void dfs(int idx){
        visited[idx] = now++;

        for(int i = graph[idx].size(); i > 0; i--){
            int next = graph[idx].get(i-1);
            if(visited[next] == 0){
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 1. 그래프 채우기
        graph = new ArrayList[N+1];
        for(int i = 1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }
        visited = new int[N+1];

        int x, y;
        for(int i=0; i<M; i++){
            StringTokenizer stNode = new StringTokenizer(br.readLine());
            x = Integer.parseInt(stNode.nextToken());
            y = Integer.parseInt(stNode.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        // 2. 정렬하기
        for(int i = 1; i<=N; i++){
            Collections.sort(graph[i]);
        }

        // 3. dfs 호출하기
        dfs(R);

        // 4. 출력하기
        for(int i = 1; i <= N; i++){
            System.out.println(visited[i]);
        }
    }
}
