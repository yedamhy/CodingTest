// https://www.acmicpc.net/problem/10816

import java.io.*;
import java.util.*;

public class Main{
    static int H, W;
    static boolean[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<Integer, Integer> sang = new HashMap<>();
        for(int n=0; n<N; n++){
            int input = Integer.parseInt(st.nextToken());
            if(sang.containsKey(input)){
               sang.put(input, sang.get(input)+1);
            }else{
                sang.put(input, 1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int m=0; m<M; m++){
            arr[m] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[M];
         
        for(int m=0; m<M; m++){
            if(sang.containsKey(arr[m])){
                result[m] = sang.get(arr[m]);
            }
        }

        for(int r : result){
            System.out.print(r + " ");
        }
    }
}
