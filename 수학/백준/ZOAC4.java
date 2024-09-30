// https://www.acmicpc.net/problem/23971
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int people =(int) Math.ceil((H+1) / (N+1)) * (int)Math.ceil((W+1) / (M+1));
        System.out.println(people);
    }
}
