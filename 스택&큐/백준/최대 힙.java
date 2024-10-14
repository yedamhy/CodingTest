//[최대 힙](https://www.acmicpc.net/problem/11279)

import java.util.*;
import java.io.*;
class Main{
    static ArrayList<Integer> sorting(ArrayList<Integer> arr, int n){
        // 이분탐색으로 삽입 위치 결정
        int left = 0;
        int right = arr.size()-1;

        if(arr.size() == 0){
            arr.add(n);
            return arr;
        }

        int mid = 0;
        while(left<=right){
            mid = (left+right) / 2;
            if(arr.get(mid) > n){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        arr.add(left, n);
        return arr;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<N; i++){
            int inputN = Integer.parseInt(br.readLine());
            // 1. 자연수 입력할 때
            if(inputN > 0){
                arr = sorting(arr, inputN);

            }else if(inputN == 0 && arr.size() >= 1){// 2. 0 입력할 때
                System.out.println(arr.get(arr.size()-1));
                arr.remove(arr.size()-1);
            }else if(inputN == 0 && arr.size() <1){
                System.out.println(0);
            }

        }



    }
}
