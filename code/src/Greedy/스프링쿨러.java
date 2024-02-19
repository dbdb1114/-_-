package Greedy;

import java.util.*;

public class 스프링쿨러 {

}

class Node implements Comparable{
    int start;
    int end;

    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Object o) {
        Node n = (Node) o;
        if(n.start == this.start){
            return this.end - n.end ;
        }
        return this.start - n.start;
    }

    @Override
    public String toString() {
        return "Node{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
class Solution3 {
    // n은 잔디 갯수
    // nums는 스프링쿨러
    public int solution(int n, int[] nums){
        int answer = 0;
        Node[] springCooler = new Node[n+1];

        for (int i = 0; i < nums.length; i++) {
            int st = Math.max(0, i-nums[i]);
            int ed = Math.min(n, i+nums[i]);
            springCooler[i] = new Node(st,ed);
        }

        Arrays.sort(springCooler);

        int st = 0;
        int ed = 0;
        int i = 0;

        while( i < springCooler.length ){
            while (i < springCooler.length && springCooler[i].start <= st){
                ed = Math.max(ed, springCooler[i].end);
                i++;
            }
            answer++;
            if(ed == n) return answer;
            if(st == ed) return -1;
            st = ed;
        }

        return answer;
    }

    public static void main(String[] args){
        Solution3 T = new Solution3();


        System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }
}
