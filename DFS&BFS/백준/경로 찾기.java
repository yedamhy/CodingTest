// https://www.acmicpc.net/problem/11403
import java.util.*;
import java.io.*;

class Main{
    static int N;
    static boolean[][] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        // 0. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new boolean[N+1][N+1];
        int[][] answer = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                graph[i][j] = st.nextToken().equals("0") ? false : true;
            }
        }
        for(int i=1; i<=N; i++){
            visited = new boolean[N+1];
            dfs(i, graph);
            for(int j=1; j<=N; j++){
                if(visited[j]){
                    answer[i][j] = 1;
                }
            }
        }

        printGraph(answer);
    }

    static void dfs(int start, boolean[][] graph){
        for(int i=1; i<=N; i++){
            if(visited[i] == false && graph[start][i]){
                visited[i] = true;
                dfs(i, graph);
            }
        }
    }

    static void printGraph(int[][] graph){
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
