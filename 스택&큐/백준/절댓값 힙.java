//[절댓값 힙](https://www.acmicpc.net/problem/11286)

import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt( (Integer a) -> Math.abs(a)).thenComparingInt(b -> b));

        for(int i=0; i<N; i++){
            int inputN = Integer.parseInt(br.readLine());
            if(inputN == 0 && pq.isEmpty()){
                System.out.println(0);
            }else if(inputN == 0 && !pq.isEmpty()){
                System.out.println(pq.poll());
            }else{
                pq.add(inputN);
            }
        }

    }
}
