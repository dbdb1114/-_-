package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 신기한_소수_찾기 {
    /**
     * 신기한 소수는 7331 처럼 7331도 소수, 733도 소수, 73도 소수, 7도 소수인 수이다.
     * 숫자 N이 주어질 때 N의 자리 숫자 중 신기한 소수를 모두 찾아보자.
     * */
    static int n;
    static int[] oddNums = {1,3,5,7,9};
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());

        int[] primeNumber = {2,3,5,7};

        Arrays.stream(primeNumber).forEach(number->{
            recurFindPrimeNumber(number,1);
        });

    }

    public static void recurFindPrimeNumber(int number, int numberLength){
        if(!isPrimeNumber(number)){
            return;
        }

        if(isPrimeNumber(number) && numberLength == n){
            System.out.println(number);
            return ;
        }

        Arrays.stream(oddNums).forEach(oddNum -> {
            int testNumber = number * 10 + oddNum;
            recurFindPrimeNumber(testNumber, numberLength + 1);
        });
    }

    public static boolean isPrimeNumber(int number){
        for(int i = 2; i <= Math.sqrt(number); i++){
            if(number%i == 0){
                return false;
            }
        }
        return true;
    }
}
