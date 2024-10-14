//[N번째 큰 수](https://www.acmicpc.net/problem/2075)

import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i=0; i<N-1; i++){
            pq.poll();
        }

        System.out.println(pq.poll());
    }
}
