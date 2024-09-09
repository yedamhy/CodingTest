// 백준 2606 실버3
// https://www.acmicpc.net/problem/2606
import java.util.*;
import java.io.*;

class Main{
    // 0. 입력 받기
    static boolean[][] graph;
    static boolean[] visited;
    static int N, M;
    static int answer;

    // 내가 현재 몇번째 노드를 처리하고 있는지
    public static void dfs(int idx){
        // 방문한 것을 true로 바꿔주기
        visited[idx] = true;
        answer++; // 1번과 연결된 컴퓨터의 개수
        for(int i = 1; i <= N; i++){ // 지금의 index를 기준으로 나랑 연결 된 애가 1부터 N까지 누가 있는지, 연결됐다면 다음거 호출
            //  i에 방문한 적이 없는지, 연결되어 있는지 -> index를 기준으로 했을 때 i번 컴퓨터에 연결된 게 맞는지
            if(visited[i] == false && graph[idx][i]){
                dfs(i);
            }

        }

    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new boolean[N+1][N+1]; // 1번부터 7번으로 쓰자.
        visited = new boolean[N+1];

        // 1. graph에 연결 정보 채우기
        int x, y;
        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()); // 띄어쓰기 기준으로 나눠줄게
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }

        // 2. dfs(재귀함수) 호출
        dfs(1); // 1번부터 시작해서 감염할 수 있는 애들을 다 감염시켜봐.

        System.out.println(answer - 1);
    }
}
