// https://school.programmers.co.kr/learn/courses/30/lessons/42576?language=java
import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        // 0. map 채우기
        for(String p : participant){
            if(map.containsKey(p)){
                int cnt = map.get(p);
                map.put(p, cnt+1);
            }else{
                map.put(p, 1);
            }
        }
        
        // 1. 완주자 제거하기
        for(String c : completion){
            map.put(c, map.get(c)-1);
        }
        
        // 2.미완주자 찾아서 반환
        for(String person : map.keySet()){
            if(map.get(person) != 0){
                return person;
            }
        }
        return " ";
    }
}
