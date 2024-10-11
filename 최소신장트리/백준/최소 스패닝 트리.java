// [최소 스패닝 트리](https://www.acmicpc.net/problem/1197)
import java.util.*;
import java.io.*;

public class Main{
    static int V, E;
    static List<Edge>[] graph;
    static boolean[] visited;
    static class Edge{
        int to, weight;
        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
    static int prim(){
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        pq.add(new Edge(1, 0));
        int totalWeight = 0;
        int visitCnt = 0;

        while(!pq.isEmpty()){
            Edge e = pq.poll();
            int currentNode = e.to;

            // 방문한 적 있는지 확인
            if(visited[currentNode]) continue;

            // 방문 처리
            visited[currentNode] = true;
            visitCnt++;
            totalWeight += e.weight;

            // 모든 노드 방문시 종료
            if(visitCnt == V) break;

            // 인접 노드 큐에 추가
            for(Edge neighbor : graph[currentNode]){
                if(!visited[neighbor.to]) pq.add(neighbor);
            }
        }

        return totalWeight;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V+1];
        visited = new boolean[V+1];

        for(int v=0; v<V+1; v++){
            graph[v] =new ArrayList<>();
        }

        for(int e=0; e<E; e++){
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
