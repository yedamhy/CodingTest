//[최소 힙](https://www.acmicpc.net/problem/1927)

import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            int inputN = Integer.parseInt(br.readLine());
            if(inputN == 0 && pq.size() == 0){
                System.out.println(0);
            }else if(inputN == 0 && pq.size() > 0){
                System.out.println(pq.poll());
            }else{
                pq.add(inputN);
            }
        }
    }
}
