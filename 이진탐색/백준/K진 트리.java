// https://www.acmicpc.net/problem/11812
import java.util.*;
import java.io.*;

public class Main {
    static long N;
    static int K, Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken()); // 노드 수
        K = Integer.parseInt(st.nextToken()); // 자식 수
        Q = Integer.parseInt(st.nextToken()); // 쿼리 수

        StringBuilder sb = new StringBuilder();

        // Q개의 쿼리 처리
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            long num1 = Long.parseLong(st.nextToken());
            long num2 = Long.parseLong(st.nextToken());
            long answer = 0;
            if(K==1){
                answer = Math.abs(num1-num2);
            }else{
                answer = findDistance(num1, num2);
            }
            System.out.println(answer);
        }

        
    }

    // 두 노드 간의 거리 계산
    static int findDistance(long num1, long num2) {
        int distance = 0;

        // 두 노드가 같아질 때까지 부모로 이동
        while (num1 != num2) {
            // 더 큰 노드를 부모로 이동
            if (num1 > num2) {
                num1 = getParent(num1);
            } else {
                num2 = getParent(num2);
            }
            distance++;
        }

        return distance;
    }

    // 부모 노드를 계산하는 메서드
    static long getParent(long node) {
        if (node == 1) return 0; // 루트 노드의 부모는 없음
        return (node - 2) / K + 1; // 부모 노드 계산
    }
}
