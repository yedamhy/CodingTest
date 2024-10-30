// https://school.programmers.co.kr/learn/courses/30/lessons/12916
import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;

        s = s.toUpperCase();

        // p 개수와 y개수 비교
        int numP = countAlphabet("P", s);
        int numY = countAlphabet("Y", s);
        System.out.println(numP+ " "+numY);
        if(numP==0 && numY==0){
            return true;
        }else if(numP == numY){
            return true;
        }
        return answer;
    }
    
    static int countAlphabet(String s, String str){
        int count = 0;
        for(int i=0; i<str.length(); i++){
            if(str.substring(i, i+1).equals(s)){
                count++;
            }
        }
        return count;
    }
}
