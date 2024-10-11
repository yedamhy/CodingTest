// https://www.acmicpc.net/problem/16398
import java.util.*;
import java.io.*;

public class Main{
    static List<Edge>[] graph;
    static boolean[] visited;
    static int N;
    static class Edge{
        int to, weight;
        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    static long prim(){
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new Edge(1, 0));

        long totalWeight = 0;
        int visitCnt = 0;

        while(!pq.isEmpty()){
            Edge e = pq.poll();
            int currentNode = e.to;

            // 방문한적 있는 지 확인
            if(visited[currentNode]) continue;

            // 방문 처리
            visited[currentNode] = true;
            visitCnt++;
            totalWeight += e.weight;

            // 모든 노드 방문시 종료
            if(visitCnt == N) break;

            // 인접 노드 큐에 추가
            for(Edge neighbor : graph[currentNode]){
                if(!visited[neighbor.to]) pq.add(neighbor);
            }
        }

        return totalWeight;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 0. 입력 받기
        N = Integer.parseInt(br.readLine());
        int[][] planet = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                planet[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // Edge로 구성된 그래프 만들기
        graph = new ArrayList[N+1];
        for(int i=0; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                graph[i+1].add(new Edge(j+1, planet[i][j]));
                graph[j+1].add(new Edge(i+1, planet[i][j]));
            }
        }
        visited = new boolean[N+1];
        long result = prim();
        System.out.println(result);
    }
}
