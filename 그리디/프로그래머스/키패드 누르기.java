// https://school.programmers.co.kr/learn/courses/30/lessons/67256
import java.util.*;

class Solution {
    static int nowLeft, nowRight;
    // 핸드폰 키패드 좌표화 *은 index 10, #은 index 11
    static int[][] phone = {{2, 4}, {1, 1}, {2, 1}, {3, 1}, {1, 2}, {2, 2}, {3, 2}, 
                            {1, 3}, {2, 3}, {3, 3}, {1, 4}, {3, 4}};
    static ArrayList<String> answer;
    
    static void finger(int focusNumber, String hand){
        int leftLen, rightLen;
        // 왼쪽 손 거리 구하기
        leftLen = Math.abs(phone[focusNumber][0] - phone[nowLeft][0]) 
            + Math.abs(phone[focusNumber][1] - phone[nowLeft][1]) ;
        
        // 오른쪽 손 거리 구하기
        rightLen = Math.abs(phone[focusNumber][0] - phone[nowRight][0]) 
            + Math.abs(phone[focusNumber][1] - phone[nowRight][1]) ;

        // 거리 비교하고 answer에 추가
        if(leftLen < rightLen){
            answer.add("L");
            nowLeft = focusNumber;
        }else if(leftLen > rightLen){
            answer.add("R");
            nowRight = focusNumber;
        }else if(leftLen == rightLen && hand.equals("left")){
            answer.add("L");
            nowLeft = focusNumber;
        }else{
            answer.add("R");
            nowRight = focusNumber;            
        }
    }
    
    public String solution(int[] numbers, String hand) {
        answer = new ArrayList<String>();
        
        nowLeft = 10;
        nowRight = 11;
        
        for(int n : numbers){
            if(n == 1 | n == 4 | n == 7){
                answer.add("L");
                nowLeft = n;
            }else if(n == 3 | n == 6 | n == 9){
                answer.add("R");
                nowRight = n;
            }else{
                finger(n, hand);
            }
        }
        
        
        
        
        return String.join("", answer);
    }
}
