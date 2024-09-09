// https://www.acmicpc.net/problem/24479
// 실버2
import java.util.*;
import java.io.*;

class Main{

    static final int MAX = 100000+10;
    static int N, M, R;
    static ArrayList<Integer>[] graph; // 하나의 배열 -> 어떤? ArrayList<Integer>의 배열
    static int[] visited;
    static int now = 1;
    public static void dfs(int idx){
        visited[idx] = now++;

        for(int i = 0; i < graph[idx].size(); i++){

            int next = graph[idx].get(i); // i 번째에 있는 요소 출력
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

        // 1. graph 채우기
        graph = new ArrayList[N+1];
        for(int i = 1; i<= N; i++){
            graph[i] = new ArrayList<>();
        }
        visited = new int[N+1];
        int x, y;
        for(int i = 0; i < M; i++){
            StringTokenizer stEdge = new StringTokenizer(br.readLine());
            x = Integer.parseInt(stEdge.nextToken());
            y = Integer.parseInt(stEdge.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }
        // 2. 오름차순 정렬
        for(int i = 1; i <=N; i++){
            Collections.sort(graph[i]);
        }
        // 3. dfs 호출
        dfs(R);

        for(int i=1; i<=N; i++){
            System.out.println(visited[i]);
        }
    }
}
