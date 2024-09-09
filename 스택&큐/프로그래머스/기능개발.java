// https://school.programmers.co.kr/learn/courses/30/lessons/42586
import java.util.ArrayDeque;
import java.util.Queue;

class Solution{
	public int[] solution(int[] progresses, int[] speeds){
		Queue<Integer> answer = new ArrayDeque<>();
		
		int n = progresses.length;
		
		// 1. 각 작업의 배포 가능일 계산
		int[] daysLeft = new int[n];
		for(int i = 0; i < n; i++){
			daysLeft[i] = (int)Math.ceil((100.0 - progresses[i])/speeds[i]);
		}
        
        // 2. 배포할 작업의 수 카운트
        int count = 0;
        
        // 3. 현재 배포될 작업 중 가장 늦게 배포 될 작업의 가능일
        int maxDay = daysLeft[0];
        
        for(int i = 0; i < n; i++){
            if(daysLeft[i] <= maxDay){
                // 배포 가능일이 가장 늦은 배포일 보다 빠르면
                count++;
            }
            else{
                answer.add(count);
                count = 1;
                maxDay = daysLeft[i];
            }
        }
        answer.add(count);
        return answer.stream().mapToInt(Integer::intValue).toArray();
	
    }

                                         
                                            
}
