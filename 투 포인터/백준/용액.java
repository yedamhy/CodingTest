//[용액](https://www.acmicpc.net/problem/2467)

import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] product = new int[N];
        for(int n=0; n<N; n++){
            product[n] = Integer.parseInt(st.nextToken());
        }
        // 투포인터 이용해서 풀 수 있다!
        int left = 0;
        int right = N-1;
        int closetSum = Integer.MAX_VALUE; // 0에 가장 가까운 합을 저장
        int[] answer = new int[2];
        
        while(left < right){
            int sum = product[left] + product[right];

            // 현재 합이 0에 더 가까울 때
            if(Math.abs(sum) < closetSum){
                closetSum = Math.abs(sum);
                answer[0] = product[left];
                answer[1] = product[right];
            }
            // 합이 양수일 때 -> 값을 줄이기 위해 오른쪽 포인터 이동
            if(sum == 0) break;
            // 합이 음수일 때 -> 값을 키우기 위해 왼쪽 포인터 이동
            else if(sum < 0) left++;
            else right--;
        }

        /*
        // 산성으로만 구성됐는지 확인
        if(product[0] > 0){
            System.out.println(product[0] + " "+ product[1]);
            return;
        }

        // 알카리성으로만 구성됐는지 확인
        if(product[N-1] < 0){
            System.out.println(product[N-1] + " "+product[N-2]);
            return;
        }

        // 알카리성 용액과 산성 용액 구분
        ArrayList<Integer> minus = new ArrayList<>();
        ArrayList<Integer> plus = new ArrayList<>();
        for(int p : product){
            if(p < 0) minus.add(p);
            else plus.add(p);
        }


         // 기본값 세팅
        int[] answer = new int[2];
        int sum = Math.abs(minus.get(0) + plus.get(0));
        answer[0] = minus.get(0);
        answer[1] = plus.get(0);

        // 산성 용액이나 알칼리성 용액이 2개 이상일 때
        int targetSum;
        if(minus.size() > 1){
            int product1 = minus.get(minus.size()-2);
            int product2 = minus.get(minus.size()-1);
            targetSum = Math.abs(product1 + product2);

            if(sum > targetSum){
                sum = targetSum;
                answer[0] = product1;
                answer[1] = product2;
            }
        }

        if(plus.size() > 1){
            int product1 = plus.get(0);
            int product2 = plus.get(1);
            targetSum = Math.abs(product1 + product2);

            if(sum > targetSum){
                sum = targetSum;
                answer[0] = product1;
                answer[1] = product2;
            }
        }

        // 산성 1개 + 알칼리성 1개 비교
        for(int m : minus){
            for(int p : plus){
                targetSum = Math.abs(m+p);
                if(sum > targetSum){
                    sum = targetSum;
                    answer[0] = m;
                    answer[1] = p;
                }
            }
        }

         */
        System.out.println(answer[0]+" "+answer[1]);
    }
}
