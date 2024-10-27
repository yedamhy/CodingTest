// https://www.acmicpc.net/problem/2805
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            trees[n] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);
        int max = trees[N-1];
        int min = 1;
        //if(min > M) min = (int) M;

        int H=0;
        int result = 0;
        long getTree;
        while(min <= max){
            H = (min+max)/2;
            getTree = 0;
            // 자른 나무 길이 구하기
            for(int t : trees){
                getTree += (t - H) > 0 ? t - H : 0;
            }
            if(getTree == M){
                System.out.println(H);
                return;
            }
            else if(getTree > M){
                // H를 높여서 얻는 나무 수 줄이기
                result = H;
                min = H+1;
            }else{
                // H를 낮춰서 얻는 나무 수 늘리기
                max = H-1;
            }

        }
        
        System.out.println(result);
    }
}
