// https://school.programmers.co.kr/learn/courses/30/lessons/258712
import java.util.*;

class Solution {
    static int[][] graph;
    public int solution(String[] friends, String[] gifts) {
        int N = friends.length;
        graph = new int[N][N];
        
        // 0. 친구들 이름으로 인덱스 쉽게 찾기 위한 hashmap
        HashMap<String, Integer> peopleIndex = new HashMap<>();
        for(int i=0; i<N; i++){
            peopleIndex.put(friends[i], i);
        }
        
        // 1. 선물 주고받은 그래프 만들기
        for(int i=0; i<gifts.length; i++){
            StringTokenizer st = new StringTokenizer(gifts[i]);
            String provider = st.nextToken();
            String recipient = st.nextToken();
            
            graph[peopleIndex.get(provider)][peopleIndex.get(recipient)]++;
        }
        
        // 2. 선물지수 배열 만들기
        int index;
        int[] giftIndex = new int[N];
        for(int i=0; i<N; i++){
            index = 0; int cntGet = 0;
            while(index < N){
                cntGet += graph[index][i];
                index++;
            }
            
            index=0; int cntTake=0;
            while(index < N){
                cntTake += graph[i][index];
                index++;
            }
            
            giftIndex[i] = cntTake - cntGet;
        }
        
        System.out.println("선물 지수 : "+Arrays.toString(giftIndex));

        
        // 3. 비교하기 
        int[] result = new int[N];

        for(int i=0; i<N-1; i++){
            for(int j=i; j<N; j++){
                // 3-1) 두 사람이 주고 받은 기록 검토
                if(graph[i][j] > graph[j][i]){
                    result[i]++;
                }else if(graph[i][j] < graph[j][i]){
                    result[j]++;
                    
                }else if((graph[i][j] == graph[j][i]) && (giftIndex[i] > giftIndex[j])){ // 3-2) 주고 받은 기록 없거나, 주고 받은 수 같다면
                    result[i]++;
                }else if((graph[i][j] == graph[j][i]) && (giftIndex[i] < giftIndex[j])){
                    result[j]++;
                }
            }
        }
        
        int maxGift = 0;  // 최댓값 저장 변수
        for (int i = 0; i < N; i++) {
            maxGift = Math.max(maxGift, result[i]);
        }
        
        return maxGift;
    }
}
