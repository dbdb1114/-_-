package Greedy;
import java.util.*;

public class 꽃이_피는_최단시간 {

}
class Solution {
    public int solution(int[] plantTime, int[] growTime){
        int[][] flowerTime = new int[plantTime.length][2];

        for (int i = 0; i < plantTime.length; i++) {
            flowerTime[i] = new int[]{plantTime[i], growTime[i]};
        }

        Arrays.sort(flowerTime,(a,b) -> b[1] - a[1]);

        int s = 0;
        int e = 0;
        int result = 0;

        for (int i = 0; i < flowerTime.length; i++) {
            e = s + flowerTime[i][0] + flowerTime[i][1];
            result = Math.max(result, e);
            s += flowerTime[i][0];
        }

        int longGrowTime = flowerTime[0][1];
        int answer = flowerTime[0][0];

        for (int i = 1; i < flowerTime.length; i++) {
            answer += flowerTime[i][0];
            longGrowTime -= flowerTime[i][0];
            longGrowTime = Math.max(longGrowTime,flowerTime[i][1]);
        }
        answer += longGrowTime;

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{1, 3, 2}, new int[]{2, 3, 2}));
        System.out.println(T.solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
        System.out.println(T.solution(new int[]{1, 1, 1}, new int[]{7, 3, 2}));
        System.out.println(T.solution(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 4, 3, 2, 1, 6}));
    }
}
