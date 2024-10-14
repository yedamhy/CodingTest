//[카드 정렬하기](https://www.acmicpc.net/problem/1715)

import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for(int n=0; n<N; n++){
            pq.add(Long.parseLong(br.readLine()));
        }
        long sum = 0;

        while(pq.size()>1){
            Long num1 = pq.poll();
            Long num2 = pq.poll();

            pq.add(num1 + num2);
            sum += num1 + num2;
        }

        System.out.println(sum);
    }
}
