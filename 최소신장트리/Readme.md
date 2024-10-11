# 최소신장트리 조건
- 모든 노드가 연결되어 있다
- 최소의 간선을 사용한다
- 가중치 존재시, 최소 비용으로 간선을 선택한다
- **사이클 형성 X**

<br>
양방향 알고리즘에서는 from은 필요 없다!

```java
static class Edge{
  int to, weight;

  public Edge(int to, int weight){
    this.to = to;
    this.weight = weight;
  }
}
```


**크루스칼 or 프림** 알고리즘이 대표적

## 1. 프림 알고리즘
### 설계 
1. `PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e->e.weight));` 를 이용해서 우선순위 큐 선언
2. 시작 노드 설정
3. 큐가 빌때까지 반복 <br>
   -1. 방문한 노드면 패스 <br>
   -2. 현재 노드 방문 처리 <br>
   -3. 현재 노드와 연결된 모든 간선을 우선순위 큐에 추가
