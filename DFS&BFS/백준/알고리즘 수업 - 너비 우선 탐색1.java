// https://acmicpc.net/problem/24444

import java.util.*;
import java.io.*;

class Main{
    static int N, M, R;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static ArrayDeque<Integer> bfsQueue;
    static int[] answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int n=1; n<=N; n++){
            graph[n] = new ArrayList<>();
        }

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int input1 = Integer.parseInt(st.nextToken());
            int input2 = Integer.parseInt(st.nextToken());

            graph[input1].add(input2);
            graph[input2].add(input1);
        }

        for(int n=1; n<=N; n++){
            Collections.sort(graph[n]);
        }

        bfsQueue = new ArrayDeque<>();
        visited = new boolean[N+1];
        answer = new int[N+1];
        int order = 1;

        visited[R] = true;
        bfsQueue.addLast(R);

        while(bfsQueue.size() > 0){
            int next = bfsQueue.removeFirst();
            answer[next] = order;
            order++;

            for(int node : graph[next]){
                if(!visited[node]){
                    visited[node] = true;
                    bfsQueue.addLast(node);
                }
            }
        }

        for(int n=1; n<=N; n++){
            System.out.println(answer[n]);
        }
    }



}
