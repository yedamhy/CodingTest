//https://www.acmicpc.net/problem/1647
import java.util.*;
import java.io.*;

public class Main{
    static int N, M;
    static List<Edge>[] graph;
    static boolean[] visited;

    static class Edge{
        int to, weight;

        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(to: " + to + ", weight: " + weight + ")";
        }

    }


    public static int prim(){
        //Comparator를 사용해 우선순위 큐를 설정
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new Edge(1, 0)); // 임의로 1번 노드부터 시작

        int totalWeight = 0;
        int maxWeight = 0;
        int edgeCount = 0;

        while(!pq.isEmpty()){
            Edge current = pq.poll();
            int currentNode = current.to;

            // 이미 방문한 노드면 무시
            if(visited[currentNode]) continue;

            // 현재 노드 방문 처리
            visited[currentNode] = true;
            totalWeight += current.weight;
            maxWeight = Math.max(maxWeight, current.weight);
            edgeCount++;

            //모든 노드 방문시 종료
            if(edgeCount == N) break;

            //현재 노드와 연결된 모든 간선을 우선순위 큐에 추가
            for(Edge nextEdge : graph[currentNode]){
                if(!visited[nextEdge.to]){
                    pq.add(nextEdge);
                }
            }

        }
        return totalWeight - maxWeight;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=0; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[node1].add(new Edge(node2, weight));
            graph[node2].add(new Edge(node1, weight));
        }

        int result = prim();
        System.out.println(result);

    }
}
