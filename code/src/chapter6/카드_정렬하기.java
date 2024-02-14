package chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class 카드_정렬하기 {
    /**
     * 정렬된 두 묶음의 숫자 카드가 있다. 각 묶음의 카드의 개수가 A,B일 때 보통 두 묶음을 합쳐
     * 1개로 만들려면 A + B번 비교해야 한다.
     *
     * 예를 들어 20장의 숫자 카드 묶음과 30장의 숫자 카드 묶음을 합치려면 50번의 비교가 필요하다.
     * 매우 많은 숫자 카드 묶음이 책상 위에 놓여 있다고 가정해보자.
     * 이들을 두 묶음식 골라 서로 합쳐 나가면 고르는 순서에 따라 비교 횟수가 달라진다.
     *
     * 예를 들어 10장, 20장, 40장의 묶음이 있다면 10장과 20장을 합친 후
     * 합친 30장 묶음과 40장을 합치면 ( 10 + 20 ) + ( 30 + 40 ) = 100번의 비교가 필요하다.
     *
     * 그러나 10장과 40장을 합친 후 합친 50장 묶음과 20장을 합치면 ( 10 + 40 ) + ( 50 + 20 ) = 120번의 비교가 필요하므로 덜 효율적이다.
     *
     * ex ) 10, 40 , 100, 150
     * 10 + 40 , 100 + 150, 50 + 250 = 300
     * 10 + 40 , 50 + 100, 150 + 150 = 500
     * 100 + 150, 40 + 250, 290 + 10 = 840
     *
     * ex ) 10, 90 , 100, 150
     * 10 + 90, 100 + 150, 100 + 250 = 700
     * 100 + 90, 190 + 150, 10 + 250 = 790
     *
     * ex ) 10, 10, 10, 100, 200
     * 10 + 10, 10 + 100, 130 + 200 = 460
     * 10 + 10, 20 + 10, 100 + 200, 30 + 300 =
     * 10 + 10, 20 + 10, 30 + 100, 130 + 200 = 510
     *
     * ex ) 10, 10, 10, 10
     * 10 + 10, 10 + 10, 20 + 20 = 80
     * 10 + 10, 20 + 10, 30 + 10 = 100
     *
     * N개의 숫자 카드 묶음의 각각의 크기가 주어질 때 최소한 몇 번의 비교가 필요한지를 구하는 프로그램을 작성하시오.
     *
     * 입력
     * 1번째 줄에 N이 주어진다.
     * 그 다음 N개의 줄에 걸쳐 숫자 카드 묶음의 각각의 크기가 주어진다.
     * 숫자 카드 묶음의 크기는 1000보다 작거나 같은 양의 정수다.
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int answer = 0;
        Queue<Integer> card = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            card.offer(Integer.parseInt(bufferedReader.readLine()));
        }

        while (card.size() > 1){
            int num1 = card.poll();
            int num2 = card.poll();

            int sum = num1 + num2;
            card.offer(sum); // 정렬된 묶음 카드를 다른 카드와 다시 합치기 위한 과정
            answer+=sum; // 묶음 카드를 정렬하는데 확인한 횟수를 합하는 과정
        }

        System.out.println(answer);
    }

}
