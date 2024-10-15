// https://school.programmers.co.kr/learn/courses/30/lessons/43162
class Solution {
    static int N;
    static int[][] computers;
    static boolean[] visited;
    static void dfs(int n){
        visited[n] = true;
        for(int i=1; i<=N; i++){
            if(computers[n][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }
    public int solution(int n, int[][] inputComputers) {
        N = n;
        visited = new boolean[N+1];
        computers = new int[N+1][N+1];
        int answer = 0;
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                computers[i+1][j+1] = inputComputers[i][j]; 
            }
        }
        
        // 연결되어 있는 컴퓨터 방문하기
        for(int i=1; i<=N; i++){
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
}
