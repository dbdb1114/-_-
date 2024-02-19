package Greedy;
import java.util.*;

public class 이동_횟수 {
    /**
     *
     * 이동 횟수
     * 물류창고에서 근무하는 현수는 n개의 물건을 A창고에서 B창고로 옮기려고 합니다.
     * 현수는 한 번에 5kg이하로만 들고 이동할 수 있습니다. 한 번에 여러개를 옮길 수 있습니다.
     * A창고에서 B창고로의 왕복을 한 번의 이동이라고 할 때 최소 이동 횟수로 n개의 물건을 모두 옮 기려고 합니다.
     * 매개변수 nums에 n개의 물건의 무게정보가 주어지면 모든 물건을 A창고에서 B창고로 옮기는데
     * 필요한 최소 이동 횟수를 반환하는 프로그램을 작성하세요.
     *
     * 제한사항:
     * • nums의 길이는 300,000을 넘지 않습니다.
     * • 모든 물건의 무게는 2kg이상 5kg이하입니다.
     */
}
class Solution1 {
    public int solution(int[] nums){
        int answer = 0;
        Arrays.sort(nums);

        int st = 0;
        int ed = nums.length - 1;

        while (st<=ed) {
            while(nums[st]+nums[ed] <= 5){
                st++;
            }
            ed--;
            answer++;
        }


        return answer;
    }

    public static void main(String[] args){
        Solution1 T = new Solution1();
        System.out.println(T.solution(new int[]{2, 5, 3, 4, 2, 3}));
        System.out.println(T.solution(new int[]{2, 3, 4, 5}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3}));
    }
}
