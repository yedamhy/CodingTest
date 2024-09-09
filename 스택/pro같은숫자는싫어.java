// https://school.programmers.co.kr/learn/courses/30/lessons/12906
import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        
        for(int n:arr){
            // 1. queue가 비어져 있으면 삽입
            if(queue.size() == 0){
                queue.addLast(n);
            }else{
                // 2. queue가 있으면 꺼내서 비교 -> 같은 값이면 하나만 다시 삽입, 다른 값이면 answer에 추가
                int queueValue = queue.pollLast();
                if(queueValue == n){
                    queue.addLast(n);
                }else{
                    answer.add(queueValue);
                    queue.addLast(n);
                }
            }
        }
        int queueValue = queue.pollLast();
        answer.add(queueValue);

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
