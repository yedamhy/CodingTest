// https://www.acmicpc.net/problem/14499
import java.io.*;
import java.util.*;

public class Main{
    static int[] dice = {2, 1, 5, 6, 4, 3};

    static void moveDice(int moveDir){
        int[] tempDice = new int[6];
        for(int i=0; i<6; i++) tempDice[i] = dice[i];

        if(moveDir == 1){ // 주사위가 동쪽으로 움직일 때
            dice[1] = tempDice[4]; dice[3] = tempDice[5];
            dice[4] = tempDice[3]; dice[5] = tempDice[1];
        }
        else if(moveDir == 2){ // 주사위가 서쪽으로 움직일 때
            dice[1] = tempDice[5]; dice[3] = tempDice[4];
            dice[4] = tempDice[1]; dice[5] = tempDice[3];
        }
        else if(moveDir == 3){ // 주사위가 북쪽으로 움직일 때
            dice[0] = tempDice[1]; dice[1] = tempDice[2];
            dice[2] = tempDice[3]; dice[3] = tempDice[0];
        }
        else if(moveDir == 4){ // 주사위가 남쪽으로 움직일 때
            dice[0] = tempDice[3]; dice[1] = tempDice[0];
            dice[2] = tempDice[1]; dice[3] = tempDice[2];
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m =0; m<M; m++){
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        // 주사위 초기 설정
        HashMap<Integer, Integer> diceNum= new HashMap<>();
        for(int i=1; i<=6; i++){
            diceNum.put(i, 0);
        }

        st = new StringTokenizer(br.readLine());
        for(int k=0; k<K; k++){
            int moveDir = Integer.parseInt(st.nextToken());
            // 1. 지도 칸 움직이기
            if(moveDir == 1){
                y++;
            }else if(moveDir==2){
                y--;
            }else if(moveDir==3){
                x--;
            }else{
                x++;
            }

            // 바깥으로 이동한 경우 처리
            if(x >= N | y >= M | x <0 | y < 0){
                if(moveDir == 1){
                    y--;
                }else if(moveDir==2){
                    y++;
                }else if(moveDir==3){
                    x++;
                }else{
                    x--;
                }
                continue;
            }

            // 2. 주사위 조작
            moveDice(moveDir);

            int bottom = dice[3];
            // 3. 지도 or 주사위 숫자 조정
            if(map[x][y] == 0){
                map[x][y] = diceNum.get(bottom);
            }else{
                diceNum.put(bottom, map[x][y]);
                map[x][y] = 0;
            }

            // 4. 윗 면 출력
            System.out.println(diceNum.get(dice[1]));
        }
    }
}
