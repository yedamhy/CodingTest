// https://school.programmers.co.kr/learn/courses/30/lessons/12981
import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> checkSame = new HashSet<>();
        checkSame.add(words[0]);
        for(int i = 1; i < words.length; i++){
            // 1. 중복된 단어가 아닌지 확인
            // 삽입 전 길이랑 삽입후 길이 비교
            int before = checkSame.size();
            checkSame.add(words[i]);
            int after = checkSame.size();
            
            if(before == after){
                answer[0] = i%n + 1;
                answer[1] = i/n + 1;
                return answer;
            }
            
            // 2. 끝말잇기 통과했는지
            boolean pass = endToStart(words[i-1], words[i]);
            if(!pass){
                answer[0] = i%n + 1;
                answer[1] = i/n + 1;
                return answer;
            }
        
            
        }
        
        return answer;
    }
    
    // 끝말잇기가 성사되는지 -> 맨 마지막 글자랑 맨 앞 글자가 같은지 확인하는 함수
    public boolean endToStart(String word1, String word2){
        
        char w1 = word1.charAt(word1.length()-1);
        char w2 = word2.charAt(0);
        
        if( w1== w2)
            return true;
        else
            return false;
        
    }
}
