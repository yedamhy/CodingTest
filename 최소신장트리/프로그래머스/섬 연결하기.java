// [섬 연결하기](https://school.programmers.co.kr/learn/courses/30/lessons/42861?language=java)
import java.util.*;

class Solution {
    static List<Edge>[] graph;
    static boolean[] visited;
    static int n;
    
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
    
    static int prim(){
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        int visitCnt = 0;
        int totalWeight = 0;
        
        pq.add(new Edge(0,0));
        
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
            if(visitCnt == n) break;
            
            // 인접 노드 큐에 추가
            for(Edge neighbor : graph[currentNode]){
                if(!visited[neighbor.to]) pq.add(neighbor);
            }
        }
        
        return totalWeight;
    }
    
    public int solution(int inputN, int[][] costs) {
        n = inputN;
        graph = new ArrayList[n];
        visited = new boolean[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] cost : costs){
            graph[cost[0]].add(new Edge(cost[1], cost[2]));
            graph[cost[1]].add(new Edge(cost[0], cost[2]));
        }
        
        
        int answer = prim();
        return answer;
    }
}
