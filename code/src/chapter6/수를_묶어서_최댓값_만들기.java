package chapter6;

import static java.util.stream.Collectors.partitioningBy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class 수를_묶어서_최댓값_만들기 {
    /**
     * 길이가 N인 수열이 주어질 대 수열의 합을 구하려고 한다.
     * 그런데 수열의 합을 구하기 전에 먼저 수열 안에 있는 임의의 두 수를 묶으려 한다.
     * 위치에 상관없이 두 수를 묶을 수 있다.
     * 단, 같은 위치에 있는 수(자기 자신)를 묶을 수는 없다.
     * 묶인 두 수는 수열의 합을 구할 때 서로 곱한 후 계산한다.
     * 수열의 모든 수는 각각 한 번씩만 묶을 수 이싿.
     * 예를 들어 어떤 수열이 {0,1,2,4,3,5}일 때 그냥 이 수열의 합을 구하면
     * 0+1+2+4+3+5 = 15 이다. 하지만 2와 3을 묶고, 4와 5를 묶으면
     * 0+ 1 + ( 2 * 3) + ( 4 * 5 ) = 27이 돼 최댓값이 나온다.
     *
     * 주어진 수열의 각 수를 적절히 묶어 그 합을 최대로 만드는 프로그램을 작성하시오
     *
     * 입력
     * 1번째 줄에 수열의 크기 N이 주어진다. N은 10,000보다 작으 자연수다.
     * 2번째 줄에 수열의 각 수가 주어진다. 수열의 수는 -10,000보다 크거나 같고,
     * 10,000보다 작거나 같은 정수다.
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bufferedReader.readLine());
        int answer = 0;

        PriorityQueue<Integer> plusNumber = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusNumber = new PriorityQueue<>();

        for (int i = 0; i < number; i++) {
            int readNumber =Integer.parseInt(bufferedReader.readLine());
            if( readNumber == 1 ){
                answer += readNumber;
            } else if ( readNumber > 1 ) {
                plusNumber.add(readNumber);
            } else {
                minusNumber.add(readNumber);
            }
        }

        answer += bindNumber(plusNumber);
        answer += bindNumber(minusNumber);

        System.out.println(answer);
    }

    public static int bindNumber(PriorityQueue<Integer> queue){
        int answer = 0;
        while (queue.size()>1){
            answer += queue.poll() * queue.poll();
        }

        if(queue.size() == 1){
            answer += queue.poll();
        }
        return answer;
    }
}
