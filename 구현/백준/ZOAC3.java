// https://www.acmicpc.net/problem/20436
import java.io.*;
import java.util.*;

public class Main{
    static char left, right;
    static char[] input;
    static HashMap<Character, int[]> leftKeyboard = new HashMap<>();
    static HashMap<Character, int[]> rightKeyboard = new HashMap<>();
    static int answer = 0;
    public static void main(String[] args) throws IOException{
        makeKeyboard();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        left = st.nextToken().charAt(0);
        right = st.nextToken().charAt(0);

        String inputStr = br.readLine();
        input = inputStr.toCharArray();

        // 왼손 검지 위치 초기 설정
        int leftX, leftY, rigthX, rigthY;
        if (leftKeyboard.containsKey(left)) {
            leftX = leftKeyboard.get(left)[0];
            leftY = leftKeyboard.get(left)[1];
        } else {
            leftX = rightKeyboard.get(left)[0];
            leftY = rightKeyboard.get(left)[1];
        }

        // 오른손 검지 위치 초기 설정
        if (leftKeyboard.containsKey(right)) {
            rigthX = leftKeyboard.get(right)[0];
            rigthY = leftKeyboard.get(right)[1];
        } else {
            rigthX = rightKeyboard.get(right)[0];
            rigthY = rightKeyboard.get(right)[1];
        }


        for(char c : input){
            int newX, newY;
            if(leftKeyboard.containsKey(c)){
                newX = leftKeyboard.get(c)[0];
                newY = leftKeyboard.get(c)[1];

                answer += Math.abs(leftX - newX)  + Math.abs(leftY - newY);
                answer ++; // 누르는 시간

                leftX = newX; leftY = newY;
            }else{
                newX = rightKeyboard.get(c)[0];
                newY = rightKeyboard.get(c)[1];

                answer += Math.abs(rigthX - newX)  + Math.abs(rigthY - newY);
                answer ++; // 누르는 시간

                rigthX = newX; rigthY = newY;
            }
        }

        System.out.println(answer);

    }

    static void makeKeyboard(){
// 왼손 자판 (1,1 부터 시작)
        leftKeyboard.put('q', new int[]{1, 1});
        leftKeyboard.put('w', new int[]{1, 2});
        leftKeyboard.put('e', new int[]{1, 3});
        leftKeyboard.put('r', new int[]{1, 4});
        leftKeyboard.put('t', new int[]{1, 5});
        leftKeyboard.put('a', new int[]{2, 1});
        leftKeyboard.put('s', new int[]{2, 2});
        leftKeyboard.put('d', new int[]{2, 3});
        leftKeyboard.put('f', new int[]{2, 4});
        leftKeyboard.put('g', new int[]{2, 5});
        leftKeyboard.put('z', new int[]{3, 1});
        leftKeyboard.put('x', new int[]{3, 2});
        leftKeyboard.put('c', new int[]{3, 3});
        leftKeyboard.put('v', new int[]{3, 4});

        // 오른손 자판 (1,6 부터 시작)
        rightKeyboard.put('y', new int[]{1, 6});
        rightKeyboard.put('u', new int[]{1, 7});
        rightKeyboard.put('i', new int[]{1, 8});
        rightKeyboard.put('o', new int[]{1, 9});
        rightKeyboard.put('p', new int[]{1, 10});
        rightKeyboard.put('h', new int[]{2, 6});
        rightKeyboard.put('j', new int[]{2, 7});
        rightKeyboard.put('k', new int[]{2, 8});
        rightKeyboard.put('l', new int[]{2, 9});
        rightKeyboard.put('b', new int[]{3, 5});
        rightKeyboard.put('n', new int[]{3, 6});
        rightKeyboard.put('m', new int[]{3, 7});
    }


}
