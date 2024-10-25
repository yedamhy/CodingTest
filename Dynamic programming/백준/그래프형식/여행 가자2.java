//https://www.acmicpc.net/problem/1976
import java.util.*;
import java.io.*;

public class Main{
    static int N, M;
    static int[][] connected;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        connected = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            Arrays.fill(connected[i], -1);
        }

        int[][] graph = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] plan = new int[M];
        for(int i=0; i<M; i++){
            plan[i] = Integer.parseInt(st.nextToken());
        }

        boolean possible = true;
        for(int i=0; i<M-1; i++){
            if(!isConnected(plan[i], plan[i+1], graph)){
                possible = false;
                break;
            }
        }

        System.out.println(possible ? "YES" : "NO");
    }

    static boolean isConnected(int start, int end, int[][]graph){
        if(connected[start][end] != -1){
            return connected[start][end] == 1;
        }
        visited = new boolean[N+1];
        boolean result = dfs(start, end, graph);
        connected[start][end] = result ? 1 : 0;
        return result;
    }

    static boolean dfs(int start, int end, int[][]graph){
        if(start == end){
            return true;
        }

        visited[start] = true;
        for(int i=1; i<=N; i++){
            if(graph[start][i] == 1&& !visited[i] ){
                if(dfs(i, end, graph)){
                    return true;
                }
            }
        }
        return false;
    }

}

