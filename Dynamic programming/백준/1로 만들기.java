// https://www.acmicpc.net/problem/1463
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] makeOne = new int[n+1];
        makeOne[1] = 0;
        for(int i=2; i<=n; i++){
            makeOne[i] = makeOne[i-1] + 1;

            if(i % 2 == 0) makeOne[i] = Math.min(makeOne[i], makeOne[i/2] + 1);

            if(i % 3 == 0) makeOne[i] = Math.min(makeOne[i], makeOne[i/3] + 1);
        }

        System.out.println(makeOne[n]);
    }
}
