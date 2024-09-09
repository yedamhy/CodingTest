// https://school.programmers.co.kr/learn/courses/30/lessons/68644?language=java
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                answer.add(numbers[i]+numbers[j]);
            }
        }
         // 중복 제거하고 정렬
        List<Integer> resultList = answer.stream().distinct().collect(Collectors.toList());
        Collections.sort(resultList);

        return resultList.stream().mapToInt(Integer::intValue).toArray();
        
    }
}
