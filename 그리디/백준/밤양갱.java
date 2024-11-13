// https://www.acmicpc.net/problem/31926
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());

        System.out.println(minTimeToCreateSong(n));
    }

    public static int minTimeToCreateSong(long n) {
        int time = 10;  // 기본적으로 n이 1일 때 필요한 시간
        long cri = 1;  // 복사 가능한 문자열 크기의 기준점

        // cri를 2배씩 증가시키며 n과 비교
        while (n >= cri * 2) {
            time += 1;
            cri *= 2;
            //System.out.println("n="+n+" time="+time+" cri="+cri);
        }

        return time;
    }
}
