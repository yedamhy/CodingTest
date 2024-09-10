// https://www.acmicpc.net/status?user_id=full08&problem_id=1388&from_mine=1

import java.util.*;
import java.io.*;

class Main{
    static int N, M, answer;
    static boolean[][] map;
    static boolean[][] visited;
    static void dfsCol(int y, int x){
        visited[y][x] = true;

        int newY = y+1;

        if(newY > N) return;
        if(map[newY][x] && visited[newY][x] == false){
            dfsCol(newY, x);
        }
    }

    static void dfsRow(int y, int x){
        visited[y][x] = true;

        int newX = x+1;
        if(newX > M) return;
        if(map[y][newX]==false && visited[y][newX] == false){
            dfsRow(y, newX);
        }


    }

    static public void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N+1][M+1];
        visited = new boolean[N+1][M+1];
        answer = 0;
        // 0. 방 바닥 장식 모양 채우기
        for(int i=1; i<=N; i++){
            String str = br.readLine();
            for(int j=1; j<=M; j++){
                if(str.charAt(j-1) == '|'){
                    map[i][j] = true;
                }else{
                    map[i][j] = false;
                }
            }
        }


        // 1. 세로 모양 | 먼저 체크
        for( int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(map[i][j] && visited[i][j] ==false){
                    answer++;
                    dfsCol(i, j);
                }
            }
        }

        // 2. 가로 모양 - 체크
        for( int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(map[i][j] == false && visited[i][j] ==false){
                    answer++;
                    dfsRow(i, j);

                }
            }
        }

        // 3. 방문 안한 칸 세기
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(visited[i][j] == false) answer++;
            }
        }

        System.out.println(answer);
    }
}
