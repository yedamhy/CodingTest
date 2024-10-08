// https://school.programmers.co.kr/learn/courses/30/lessons/49993
import java.util.*;

class Solution {
    static HashMap<Character, Integer> skillMap;
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String skill_tree : skill_trees){
            // 1. (skill, 0)인 skillMap 만들기
            skillMap = new HashMap<>();
            
            // 2.skill 위치 찾아서 skillMap update
            for(int i=0; i<skill.length(); i++){
                linearSearch(skill.charAt(i), skill_tree);
            }
            
            // 3. skillMap에서 skill 순서 맞는지 확인
            if(checkSkill(skill)){
                answer++;   
            }

            
        }
        
        
        return answer;
    }
    
    public void linearSearch(char target, String skill_tree){
        for(int i=0; i < skill_tree.length(); i++){
            if(skill_tree.charAt(i) == target){
                skillMap.put(target, i);
                return;
            }
        }
    }
    
    public boolean checkSkill(String skill){
        ArrayList<Integer> order = new ArrayList<>();
        for(int i=0; i<skill.length(); i++){
            if(skillMap.containsKey(skill.charAt(i))){
                order.add(skillMap.get(skill.charAt(i)));
            }else{
                order.add(26);
            }
        }
        
        ArrayList<Integer> sorting = new ArrayList<>();
        for(int n : order){
            sorting.add(n);
        }
        Collections.sort(sorting);
        
        // 정렬 전과 후가 같다면 가능한 스킬트리  
        for(int i=0; i<sorting.size(); i++){
            if(order.get(i) != sorting.get(i)){
                return false;
            }
        }
        return true;
    }
}
