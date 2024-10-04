// https://school.programmers.co.kr/learn/courses/30/lessons/340212#
import java.util.*;
class Solution {
    static int[] diffs;
    static int[] times;
    static long limit;
    
    // level이 주어질 때 걸리는 시간 계산
    static long calTime(int level){
        long timeCnt=0;
        timeCnt += times[0];
        if(diffs.length == 1) return timeCnt;
        for(int i=1; i<diffs.length; i++){
            if(diffs[i] > level){
                timeCnt += (times[i] + times[i-1]) * (diffs[i] - level) + times[i];
            }else{
                timeCnt += times[i];
            }
        }
        return timeCnt;
    }
    
    public int solution(int[] diffsInput, int[] timesInput, long limit) {
        diffs = diffsInput;
        times = timesInput;
        
        int answer = Integer.MAX_VALUE;

        int left = 1;
        int right = Arrays.stream(diffs).max().getAsInt();
        long timeCnt;
        
        if(left > right) answer = Arrays.stream(times).sum();
        while(left <= right){
            int mid = (left + right) / 2;
            timeCnt = calTime(mid);
            if(timeCnt > limit){
                left = mid + 1;
            }else{
                answer = Math.min(answer, mid);
                right = mid-1;
            }
            
        }
        
        return answer;
    }
}
