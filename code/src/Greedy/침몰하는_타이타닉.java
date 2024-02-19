package Greedy;
import java.util.*;

public class 침몰하는_타이타닉 {
/**
 * 유럽에서 가장 유명했던 유람선 타이타닉이 침몰하고 있습니다.
 * 유람선에는 N명의 승객이 타고 있습니다.
 * 구명보트를 타고 탈출해야 하는데
 * 타이타닉에 있는 구명보트는 2명 이하로만 탈 수 있으며,
 * 보트 한 개에 탈 수 있는 총 무게도 M kg 이하로 제한되어 있습니다.
 * 매개변수 nums에 N명의 승객 몸무게가 주어지고,
 * m에 보트 한 개에 탈 수 있는 제한 무개가 주어지면,
 * 승객 모두가 탈출하기 위한 구명보트의 최소개수를 반환하는 프로그램을 작성하시오.
 * */
}
class Solution2 {
    public int solution(int[] nums, int m){
        int answer = 0;

        Arrays.sort(nums);

        int st = 0;
        int ed = nums.length - 1;

        while(st<=ed){
            if(nums[st] + nums[ed] <= m){
                answer++;
                st++;
                ed--;
            } else {
                answer++;
                ed--;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Solution2 T = new Solution2();
        System.out.println(T.solution(new int[]{90, 50, 70, 100, 60}, 140));
        System.out.println(T.solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
        System.out.println(T.solution(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120));
    }
}
