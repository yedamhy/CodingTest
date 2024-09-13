// https://school.programmers.co.kr/learn/courses/30/lessons/42862

import java.util.*;
// 여벌의 체육복을 최대한 빌려준 뒤 
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        HashSet<Integer> reserveStudent = new HashSet<>();
        for(int r : reserve){
            reserveStudent.add(r);
        }
        
        Arrays.sort(lost);
        HashSet<Integer> lostStudent = new HashSet<>();
        for(int l : lost){
            // 도난 당한 사람이 여분 있는지 체크 
            if(reserveStudent.contains(l)){
                reserveStudent.remove(l);
            }else{
                lostStudent.add(l);
            }
            
            
        }
        
        
        
        for(int student : lost){

            // 1.lost학생 중 빌릴 수 있는 사람은 빌린다. -> lost, reserve에서 제거
            if(reserveStudent.contains(student-1)){
                lostStudent.remove(student);
                reserveStudent.remove(student-1);
            }else if(reserveStudent.contains(student+1)){
                lostStudent.remove(student);
                reserveStudent.remove(student+1);
            }

        }
        // 2.전체 인원수 - lost에 남이 있는 사람 수
        
        return n - lostStudent.size();
    }
}
