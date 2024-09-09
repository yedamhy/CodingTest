// https://school.programmers.co.kr/learn/courses/30/lessons/1845
import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {

        int getNum = nums.length/2;
        HashSet<Integer> noSamePhone = new HashSet<>();
        
        for(int n : nums){
            noSamePhone.add(n);
        }
        
        // 해쉬에 넣었을 때, 가져가는 개수보다 종류가 많으면 가져가는 개수 그대로 반환
        if(noSamePhone.size() >= getNum)
            return getNum;
        
        // 해쉬 개수가 적으면 조합 시작
        
        
        return noSamePhone.size();
    }
}
