// [전기가 부족해](https://www.acmicpc.net/problem/10423)
import java.util.*;
import java.io.*;

public class Main{
    static int N, M, K;
    static List<Edge>[] graph;
    static boolean[] visited;
    static int[] station;
    static class Edge{
        int to, weight;
        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    static long prim(){
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing(e -> e.weight));

        long totalWeight = 0;
        int visitCnt = 0;

        for(int s : station){
            pq.add(new Edge(s, 0));
        }

        while(!pq.isEmpty()){
            Edge e = pq.poll();
            int currentNode = e.to;

            // 방문 했는지 확인
            if(visited[currentNode]) continue;

            // 방문 처리
            visited[currentNode] = true;
            totalWeight += e.weight;
            visitCnt++;

            // 모든 노드 방문시 종료
            if(visitCnt == N) break;

            // 인접 노드 큐에 추가
            for(Edge neighbor : graph[currentNode]){
                if(visited[neighbor.to] == false) pq.add(neighbor);
            }
        }
        return totalWeight;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        station = new int[K];

        for(int i=0; i<N+1; i++){
            graph[i] =new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int k=0; k<K; k++){
            station[k] = Integer.parseInt(st.nextToken());
        }

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[node1].add(new Edge(node2, weight));
            graph[node2].add(new Edge(node1, weight));
        }

        long result = prim();

        System.out.println(result);
    }
}
