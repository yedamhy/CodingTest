// [탑](https://www.acmicpc.net/problem/2493)
import java.util.*;
import java.io.*;

public class Main{
    static class Building{
        int number, height;
        public Building(int number, int height){
            this.number = number;
            this.height = height;
        }

        @Override
        public String toString(){
            return "number : "+number + " height : "+height + "\n";
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> answerArr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Building> stack = new ArrayDeque<>();
        for(int i=1; i<=N; i++){


            int answer = 0;
            int height = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty()){
                Building target = stack.pop();
                if(target.height >= height){
                    answer = target.number;
                    stack.push(target);
                    break;
                }
            }

            answerArr.add(answer);
            stack.push(new Building(i, height));
        }

        for(int i=0; i<N; i++){
            System.out.print(answerArr.get(i) + " ");
        }
    }
}
