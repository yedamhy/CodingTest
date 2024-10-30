// https://school.programmers.co.kr/learn/courses/30/lessons/147355
import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int pLen = p.length();
        long pNum = Long.parseLong(p);  // Long으로 변경
        
        for (int i = 0; i <= t.length() - pLen; i++) {
            long tNum = Long.parseLong(t.substring(i, i + pLen));  // Long으로 변경
            if (tNum <= pNum) {
                answer++;
            }
        }
        
        return answer;
    }
}
