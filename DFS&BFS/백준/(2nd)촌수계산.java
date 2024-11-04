// https://www.acmicpc.net/problem/2644
import java.util.*;
import java.io.*;

class Main{
    static int N, M, p1, p2;
    static boolean[] visited;
    static boolean[][] family;
    static int result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        family = new boolean[N+1][N+1];
        visited = new boolean[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        result = 0;
        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int input1 = Integer.parseInt(st.nextToken());
            int input2 = Integer.parseInt(st.nextToken());

            family[input1][input2] = true;
            family[input2][input1] = true;
        }

        dfs(p1, p2, 0);
        if(result == 0) result = -1;
        System.out.println(result);
    }

    static void dfs(int start, int target, int depth){
        visited[start] = true;
        depth++;
        for(int n=1; n<=N; n++){
            if(n == target && family[start][n]){
                result = depth;
                return;
            }

            if(!visited[n] && family[start][n]){
                dfs(n, target, depth);
            }
        }

    }
}
