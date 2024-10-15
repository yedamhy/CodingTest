// https://school.programmers.co.kr/learn/courses/30/lessons/42587
import java.util.*;

class Solution {
    static class Process{
        int location, priority;
        public Process(int location, int priority){
            this.location = location;
            this.priority = priority;
        }
    }
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Deque<Process> queue = new ArrayDeque<>();
        for(int i=0; i<priorities.length; i++){
            pq.add(priorities[i]);
            queue.offer(new Process(i, priorities[i]));
        }
        
        int answer = 0;
        for(int i=0; i<priorities.length; i++){
            int targetPriority = pq.poll();
            
            Process outProcess = new Process(0,0);
            while(true){
                outProcess = queue.poll();
                if(outProcess.priority == targetPriority){
                    answer++;
                    break;
                }
                queue.offer(outProcess);
            }
            
            if (location == outProcess.location){
                break; 
            }
        }
        
        return answer;
    }
}
