// https://www.acmicpc.net/problem/1010
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long result = combination(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            System.out.println(result);
        }
    }

    static long combination(int n, int m) {
        if (n > m) return 0; // 잘못된 경우

        long result = 1;
        // (m * (m-1) * ... * (m-n+1)) / (1 * 2 * ... * n)
        for (int i = 0; i < n; i++) {
            result *= (m - i);
            result /= (i + 1);
        }
        return result;
    }
}
