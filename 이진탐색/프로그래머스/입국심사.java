// https://school.programmers.co.kr/learn/courses/30/lessons/43238

import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long left = 1;
        long right = (long) times[times.length - 1] * n;
        
        long answer = right;
        while(left <= right){
            long mid = (left+right) / 2;
            
            long hap = 0;
            for(int time : times){
                hap += mid / time;
            }
            
            if(hap >= n){
                answer = mid;
                right = mid-1;
            }else{
                left = mid + 1;
            }
        }
        
        
        return answer;
    }
}
