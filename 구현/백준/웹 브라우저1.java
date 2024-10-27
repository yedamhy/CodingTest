// https://www.acmicpc.net/problem/23294
import java.util.*;
import java.io.*;

public class Main{
    static int N, Q, C, sumCache, nowPageNum;
    static int[] pagesCache;
    static ArrayDeque<Page> backSpace;
    static ArrayDeque<Page> frontSpace;

    static class Page{
        int pageNum;
        int cache;

        public Page(int pageNum, int cache){
            this.pageNum = pageNum;
            this.cache = cache;
        }

        @Override
        public String toString(){
            return "["+pageNum+","+cache+"] ";
        }
    }

    static void backward(){
        // 1. 뒤로 가기 공간에 1개 이상 페이지 저장되어 있나 확인
        if(backSpace.isEmpty()) return;

        // 2. 현재 보고 있는 웹페이지를 앞으로 가기 공간에 저장
        frontSpace.addLast(new Page(nowPageNum, pagesCache[nowPageNum]));

        // 3. 뒤로 가기 공간에서 최근 페이지 접속, 해당 페이지는 뒤로 가기 공간에서 삭제
        nowPageNum = backSpace.removeLast().pageNum;
    }

    static void frontward(){
        // 1. 앞으로 가기 공간에서 1개 이상 페이지 저장되어 있나 확인
        if(frontSpace.isEmpty()) return;

        // 2. 현재 보고 있는 페이지 뒤로 가기 공간에 저장
        backSpace.addLast(new Page(nowPageNum, pagesCache[nowPageNum]));

        // 3. 앞으로 가기 공간에서 방문한지 가장 최근 페이지 접속, 앞으로 가기 공간에서 삭제
        nowPageNum = frontSpace.removeLast().pageNum;
    }

    static void access(Page accessPage){
        // 1. 앞으로 가기 공간에 저장된 페이지가 모두 삭제된다. (페이지들이 차지 하고 있던 크기만큼 현재 사용 캐시에서 줄어든다.)
        for(Page page : frontSpace){
            sumCache -= page.cache;
        }
        frontSpace.clear();

        // 2-1. 현재 페이지를 뒤로 가기 공간에 추가하고 현재 페이지 갱신
        if(nowPageNum != 0){ // 처음으로 접속할 때는 현재 페이지 뒤로가기 공간에 추가X
            backSpace.addLast(new Page(nowPageNum, pagesCache[nowPageNum]));
        }

        // 2-2. 방문한 페이지 캐시 용량 추가
        nowPageNum = accessPage.pageNum;
        sumCache += accessPage.cache;

        // 3. 캐시 용량 초과시 가장 오래전에 방문한 페이지 삭제
        while(sumCache > C){
            sumCache -= backSpace.removeFirst().cache;
        }
    }

    static void compress(){
        // 1. 뒤로 가기 공간에서 같은 페이지가 연속해서 2개 이상 등장하면 하나만 납두고 삭제
        if (backSpace.isEmpty()) return;

        ArrayDeque<Page> newBackSpace = new ArrayDeque<>();
        Page prev = backSpace.pollFirst();
        newBackSpace.addLast(prev);

        while (!backSpace.isEmpty()) {
            Page curr = backSpace.pollFirst();
            if (curr.pageNum != prev.pageNum) {
                newBackSpace.addLast(curr);
                prev = curr;
            } else {
                sumCache -= curr.cache;
            }
        }
        backSpace = newBackSpace;

    }

    static void printSpace(ArrayDeque<Page> pages) {
        if (pages.isEmpty()) {
            System.out.println(-1);
            return;
        }

        // 페이지를 임시로 저장하여 순서대로 출력
        List<Integer> pageNums = new ArrayList<>();
        for (Page page : pages) {
            pageNums.add(page.pageNum);
        }
        Collections.reverse(pageNums);
        for (int pageNum : pageNums) {
            System.out.print(pageNum + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        pagesCache = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int n=1; n<=N; n++){
            pagesCache[n] = Integer.parseInt(st.nextToken());
        }

        backSpace = new ArrayDeque<>();
        frontSpace = new ArrayDeque<>();

        for(int q=0; q<Q; q++){
            st = new StringTokenizer(br.readLine());
            String action = st.nextToken();
            if(action.equals("B")){
                backward();
            }else if(action.equals("F")){
                frontward();
            }else if(action.equals("A")){
                int pageNum = Integer.parseInt(st.nextToken());
                access(new Page(pageNum, pagesCache[pageNum]));
            }else if(action.equals("C")){
                compress();
            }
        }

        System.out.println(nowPageNum);
        printSpace(backSpace);
        printSpace(frontSpace);
    }
}
