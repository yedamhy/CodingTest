// https://school.programmers.co.kr/learn/courses/30/lessons/12985
class Solution{
	public int solution(int n, int a, int b)[
		int answer;
		
		for(answer=0; a!=b; answer++){
			a = (a+1)/2;
			b = (b+1)/2;
		}
		return answer;
	}
}
