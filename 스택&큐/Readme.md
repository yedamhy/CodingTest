# Queue
FIFO(First In First Out)
```java
import java.util.ArrayDeque;
import java.util.Deque;

public class QueueExample {
    public static void main(String[] args) {
        // ArrayDeque를 큐로 사용
        Deque<Integer> queue = new ArrayDeque<>();

        // 요소 삽입 (큐의 끝에 추가)
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        // 큐에서 요소 꺼내기 (FIFO)
        System.out.println(queue.poll()); // 10
        System.out.println(queue.poll()); // 20
        System.out.println(queue.poll()); // 30
    }
}
```
### 주요 메서드
- `offer(E e)`: 큐의 끝에 요소를 추가.
- `poll()`: 큐의 앞에서 요소를 제거하고 반환 (없으면 null).
- `peek()`: 큐의 앞에 있는 요소를 제거하지 않고 반환.

# Stack
LIFO(Last In First Out)
```java
import java.util.ArrayDeque;
import java.util.Deque;

public class StackExample {
    public static void main(String[] args) {
        // ArrayDeque를 스택으로 사용
        Deque<Integer> stack = new ArrayDeque<>();

        // 요소 삽입 (스택의 위에 추가)
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // 스택에서 요소 꺼내기 (LIFO)
        System.out.println(stack.pop()); // 30
        System.out.println(stack.pop()); // 20
        System.out.println(stack.pop()); // 10
    }
}
```

### 주요 메서드
- `push(E e)`: 스택의 맨 위에 요소를 추가.
- `pop()`: 스택의 맨 위 요소를 제거하고 반환.
- `peek()`: 스택의 맨 위 요소를 제거하지 않고 반환.

# 우선순위 큐 (Priority Queue)
우선순위가 높은 요소를 먼저 처리하는 자료구조

- 최소 힙 (basic)
```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.offer(10);
pq.offer(30);
pq.offer(20);

// 최솟값 출력
System.out.println(pq.peek()); // 10
```

- 최대 힙
```java
PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
pq.offer(10);
pq.offer(30);
pq.offer(20);

// 최댓값 출력
System.out.println(pq.peek()); // 30

```

### 우선순위 큐의 주요 메서드
- `offer(E e)`: 요소 삽입 (O(log N)).
- `poll()`: 우선순위가 가장 높은 요소 제거 (O(log N)).
- `peek()`: 우선순위가 가장 높은 요소 조회 (O(1)).
