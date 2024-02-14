package chapter6;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 동전_개수의_최솟값_구하기 {
    /***
     * 준규가 소유하고 있는 동전은 총 N 종류이고,
     * 각 동전의 개수가 많다.
     * 동전을 적절히 사용해 그 가격의 합을 K로 만들려고 한다.
     * 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
     *
     * 입력
     * 1번째 줄에 N과 K(1<= N <= 10, 1 <= K <= 100,000,000),
     * 2번째 줄부터 N개의 줄에 동전의 가격 A가 오름차순으로 주어진다.
     * ( 1 <= A <= 1,000,000, A = 1, i>=2일 때 A는 A의 배수 ).
     *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] readline = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = readline[0];
        int money = readline[1];
        int totalCoin = 0;

        int[] currency = new int[N];

        for (int i = N-1; i >= 0; i--) {
            currency[i] = Integer.parseInt(bufferedReader.readLine());
        }

        for (int i = 0; i < N; i++) {
            int price = currency[i];

            if(price <= money){
                totalCoin += money/price;
                money = money%price;
            }
        }
        System.out.println(totalCoin);
    }

}
