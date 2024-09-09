// https://school.programmers.co.kr/learn/courses/30/lessons/77486

import java.util.Arrays;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        int[] answer = new int[enroll.length];
        int[] parent = new int[enroll.length];
        
        Arrays.fill(parent, -1);
        
        for(int i = 0; i < enroll.length; i++){
            if(!referral[i].equals("-")){
                parent[i] = Arrays.asList(enroll).indexOf(referral[i]);
            }
        }
        
        for(int i = 0; i<seller.length; i++){
            int money = amount[i] * 100;
            int currentIndex = Arrays.asList(enroll).indexOf(seller[i]);
            
            while(currentIndex != -1 && money > 0){
                int commission = money / 10;
                answer[currentIndex] += money - commission;
                money = commission;
                currentIndex = parent[currentIndex];
            }
        }
        
        
        return answer;
    }
}
