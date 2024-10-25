// https://www.acmicpc.net/problem/1976
import java.util.*;
import java.io.*;

public class Main{
    static int N, M;
    static boolean status;
    static HashSet<Integer>[] cities;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        // 입력 받기
        cities = new HashSet[N+1];
        int inputNum = 0;
        for(int n=1; n<=N; n++){
            cities[n] = new HashSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i=1; i<=N; i++){
                inputNum = Integer.parseInt(st.nextToken());
                cities[n].add(n);
                if(inputNum == 1){
                    cities[n].add(i);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] plan = new int[M];
        for(int m=0; m<M; m++){
            plan[m] = Integer.parseInt(st.nextToken());
        }

        int start, end = 0;
        for(int i=0; i<M-1; i++){
            start = plan[i];
            end = plan[i+1];
            visited = new boolean[N+1];
            status = false;
            dfs(start, end);
            if(status){
                for(int j=1; j<=N; j++){
                    if(visited[j]) cities[start].add(j);
                }
            }else{
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    static void dfs(int start, int target){
        visited[start] = true;
        if(cities[start].contains(target)){
            status = true;
            return;
        }

        for(int city : cities[start]){
            if(!visited[city]){
                dfs(city, target);
            }
        }
    }
}

