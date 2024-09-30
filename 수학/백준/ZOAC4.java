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

        int rows = (int) Math.ceil((double) H/ (N+1));
        int cols = (int) Math.ceil((double) W / (M+1));
        System.out.println(rows * cols);
    }
}
