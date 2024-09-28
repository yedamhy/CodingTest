// https://www.acmicpc.net/problem/3758
import java.util.*;
import java.io.*;

public class Main{
    static class Team{
        int id; // team Id
        int score; // 팀 점수
        int submitCount; // 제출 횟수
        int lastSubmitTime; // 마지막 제출 시간

        public Team(int id, int score, int submitCount, int lastSubmitTime){
            this.id = id;
            this.score = score;
            this.submitCount = submitCount;
            this.lastSubmitTime = lastSubmitTime;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 팀의 개수
            int k = Integer.parseInt(st.nextToken()); // 문제 개수
            int myId = Integer.parseInt(st.nextToken()); // 내 팀 ID
            int m = Integer.parseInt(st.nextToken()); // 로그 엔트리 개수

            // 팀별 점수 기록
            int[][] scores = new int[n+1][k+1];
            int[] totalScore = new int[n+1];
            int[] submitCnt = new int[n+1];
            int[] lastSubmitTime = new int[n+1];

            // 로그 입력 채우기
            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int teamId = Integer.parseInt(st.nextToken());
                int problemNum = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                // 최고 점수 업데이트
                if(scores[teamId][problemNum] < score) {
                    totalScore[teamId] -= scores[teamId][problemNum];
                    scores[teamId][problemNum] = score;
                    totalScore[teamId] += score;
                }

                // 제출 횟수 및 마지막 제출 시간 업데이트
                submitCnt[teamId]++;
                lastSubmitTime[teamId] = i;
            }

            List<Team> teams = new ArrayList<>();
            for(int i=1; i<=n; i++){
                teams.add(new Team(i, totalScore[i], submitCnt[i], lastSubmitTime[i]));
            }

            // 순위대로 정렬
            teams.sort((a, b) -> {
                if(a.score != b.score){
                    return Integer.compare(b.score, a.score); // 점수 비교 - 내림차순
                }else if(a.submitCount != b.submitCount){
                    return Integer.compare(a.submitCount, b.submitCount);
                }else{
                    return Integer.compare(a.lastSubmitTime, b.lastSubmitTime);
                }
            });

            // 내 팀 순위 계산
            int rank = 1;
            for(int i=0; i<teams.size(); i++){
                if(teams.get(i).id == myId){
                    rank = i+1;
                    break;
                }
            }
            System.out.println(rank);
        }
    }
}
