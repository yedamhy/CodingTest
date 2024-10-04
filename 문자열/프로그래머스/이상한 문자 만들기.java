// https://school.programmers.co.kr/learn/courses/30/lessons/12930
import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        int index = 0;
        for(int i=0; i<s.length(); i++){
            // 공백이면
            if(s.charAt(i) == ' '){
                // 단어 인덱스 초기화
                index = 0;
                answer += " ";
                continue;
            }
            
            // 인덱스가 짝수이면
            if(index%2 == 0){
                answer += Character.toString(Character.toUpperCase(s.charAt(i)));
                
            }else{
                answer+= Character.toString(Character.toLowerCase(s.charAt(i)));
            }
            index++;
        }
        
        return answer;
    }
}
