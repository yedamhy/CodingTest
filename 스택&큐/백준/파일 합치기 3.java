//[파일 합치기 3](https://www.acmicpc.net/problem/13975)

import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T --> 0){
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            long sum = 0;
            for(int i=0; i<k; i++){
                long inputN = Long.parseLong(st.nextToken());
                pq.add(inputN);
            }
            while(pq.size() > 1){
                long num1 = pq.poll();
                long num2 = pq.poll();

                pq.add(num1+num2);
                sum += num1 + num2;
            }

            System.out.println(sum);

        }
    }
}
