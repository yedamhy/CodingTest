// https://school.programmers.co.kr/learn/courses/30/lessons/84512
class Solution {
    public int solution(String word) {
        int[] jump = {781, 156, 31, 6, 1};
        String vowels = "AEIOU";
        int answer = 0;
        
        for (int i = 0; i < word.length(); i++) {
            // 해당 자리에서 해당 글자가 몇 번째에 있는지 확인
            int index = vowels.indexOf(word.charAt(i));
            // 뛰어넘는 단어의 수를 더해줌
            answer += index * jump[i] + 1;
        }
        
        return answer;
    }
}
