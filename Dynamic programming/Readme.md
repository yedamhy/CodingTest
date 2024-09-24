# DP를 언쩨 서야 할까?
DP를 써야 할 때 자주 나오는 상황: <br>

<br>

- **최소 값, 최대 값을 구해라**: <br>
예를 들어, "가장 적은 횟수로 1을 만들어라", "가장 저렴하게 도달해라" 이런 문제들.<br> 
예시: '1로 만들기' 문제에서는 3가지 방법(1 빼기, 2로 나누기, 3으로 나누기) 각각의 방법이 겹치니까 한 번 구한 값을 저장해두면? 중복 계산을 피할 수 있다. <br>

- **큰 문제를 풀기 위해 그 전에 풀었던 작은 문제의 결과가 필요할 때**. →  DP! <br>
예시: 피보나치 수열은 n번째 수를 구하려면 n-1번째와 n-2번째 수를 더해야 하니깐 작은 문제들(피보나치 n-1, n-2)로 큰 문제(n번째 피보나치)를 해결 <br>


- **똑같은 계산을 여러 번 해야 하는 경우** <br>
예시: 계단 오르기 문제에서 "한 계단을 어떻게 올라갈 수 있을까?"를 생각할 때, 2계단 뒤나 1계단 뒤에서 올라오는 경우가 반복됨. 이걸 미리 계산해서 저장해 두면, 나중에 빠르게 풀 수 있다.

## DP 문제 푸는 기본 공식
1. **문제를 작은 부분으로 나눌 수 있는가?** <br>
큰 문제를 작은 문제로 나누어도 동일한 해결 방법을 적용할 수 있을 때 →  DP고려
2. **이미 풀었던 문제를 또 푸는가?** <br>
같은 값을 다시 구하는 일이 많으면, 메모이제이션(값을 저장해두고 다시 쓰기)을 써야 효율적

# DP란

완전탐색처림 시간이 많이 걸리는 문제를 해결하기 위해 나온 알고리즘

예를 들어 정수 삼각형 문제를 보자→

삼각형 꼭대기에서 바닥까지 어이지는 경로 중, 거쳐간 숫자의 합이 가장 큰 경우를 찾아보려고 합니다.

아래 칸으로 이동할 때는 대각선 방향으로 한 칸 오른쪽 또는 왼쪽으로만 이동 가능합니다.

예를 들어 3에서는 그 아래칸의 8또는 1로만 이동이 가능합니다.

삼각형의 정보가 담긴 배열 triangle이 매개변수로 주어질 때, 거쳐간 숫자의 최댓값을 return 하도록 solutin 함수를 완성해라

```
		      7
		    3   8
		  8   1   0
		2   7   4   4
	      4   5   2   6   5

```

**DFS를 이용해서 푼다면?**

7 → 3 → 8 → 2 → 4  max : 24

7 → 3 → 8 → 2 → 5 sum : 25⇒ max갱신 

7 → 3 → 8 → 7 → 5 max 갱신 

모든 경우의 수를 다 따져보면 최댓값이 30

→ 중복적인 연산이 많음

7 → 3 즉 7+3을 많은 연산에서 계쏙 하는 중

컴퓨터에 저장하기 위해서는 

![image](https://github.com/user-attachments/assets/8dad14cd-e064-4d29-903b-c24153d8a0ba)

이런식으로 그래프로 나타낼 수 있음

DP 삼각형 그래프를 하나 더 만들어서 수행한 연산의 결과를 저장해야 함

해당 위치까지 올 수 있는 최댓값을 저장하는 배열!

왜 DP보단 기억하고 풀기 라는 이름이 더 직관적이다.

### DP인걸 어떻게 알고 풀 수 있을까?

1. **DFS/BFS로 풀 수 있지만 경우의 수가 너무 많은 경우**
    
    최악의 수가 너무 많을 때는 시간초과가 나겠지.
    
2. **경우의 수들에 중복적인 조합이 많은 경우**