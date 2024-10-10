// https://school.programmers.co.kr/learn/courses/30/lessons/250136
import java.util.*;
class Solution {
    static boolean[][] visited;
    static int n, m, oilCnt, landId;
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1}; 
    static int[][] land;
    static int[][] landIdMap;
    
    static void dfs(int x, int y){
        oilCnt++;
        visited[x][y] = true;
        landIdMap[x][y] = landId;
        
        for(int i=0; i<4; i++){
            int newX = x + moveX[i];
            int newY = y + moveY[i];
            
            // 범위 벗어나는 지 체크
            if(newX >= n | newX < 0 | newY >=m | newY <0) continue;
            
            if(visited[newX][newY] == false && land[newX][newY] == 1){
                dfs(newX, newY);
            }
        
        }
        
    }
    
    public int solution(int[][] landInput) {
        land = landInput;
        
        n = land.length; // 세로
        m = land[0].length; // 가로
        visited = new boolean[n][m];
        landIdMap = new int[n][m];
        
        landId = 1;
        HashMap<Integer, Integer> oilSize = new HashMap<>(); // {landId, 덩어리의 석유량}
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j] == false && land[i][j] == 1){
                    oilCnt = 0;
                    dfs(i, j);
                    oilSize.put(landId, oilCnt);
                    landId++;
                }
            }
        }
        
        
        int maxOil = 0;
        for(int y=0; y<m; y++){
            HashSet<Integer> landIdCheck = new HashSet<>();
            
            for(int x=0; x<n; x++){
                if(landIdMap[x][y] > 0){
                    landIdCheck.add(landIdMap[x][y]);
                }
            }
            
            int result = 0;
            for(int id : landIdCheck){
                result += oilSize.get(id);
            }
            
            maxOil = Math.max(maxOil, result);
        }
        
        
        return maxOil;
    }
}
