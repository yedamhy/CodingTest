// https://school.programmers.co.kr/learn/courses/30/lessons/43238
import java.util.*;

class Solution {
public long solution(int n, int[] times) {
    long answer = 0;
    Arrays.sort(times);
    long min = 0;
    long max = (long) times[times.length - 1]*n;

    while(min <= max){
        long mid = (min+max)/2;

        long sum=0;

        for(int time:times){
            sum += mid/time;
        }

        if(sum >= n){
            answer = mid;
            max = mid - 1;
        }else{
            min = mid + 1;
        }
    }        

    return answer;
}
}
