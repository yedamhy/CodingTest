//[가운데를 말해요](https://www.acmicpc.net/problem/1655)
import java.util.*;
import java.io.*;
class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minPq = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());

            // 1. 최대힙에 우선 넣기
            if(maxPq.size() == minPq.size()){
                maxPq.add(num);
            }else{
                minPq.add(num);
            }

            // 최대 힙의 루트가 최소힙의 루트보다 큰 경우 스압
            if(!minPq.isEmpty() && maxPq.peek() > minPq.peek()){
                int maxVal=maxPq.poll();
                int minVal = minPq.poll();

                maxPq.add(minVal);
                minPq.add(maxVal);
            }

            System.out.println("max : "+maxPq);
            System.out.println("min : "+minPq);
            // 중앙값 출력
            System.out.println(maxPq.peek());
        }
    }
}
