package chapter5.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PublicKey;
import java.util.Arrays;

public class 원하는_정수_찾기 {
    /**
     * N개의 정수 A[1],A[2], ---, A[N]이 주어져 있을 때 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
     *
     * 입력
     * 1번째 줄에 자연수 N(1 <= N <= 100,000), 그다음 줄에 N개의 정수 A[1],A[2]... A[N]이 주어진다.
     * 그 다음 줄에 M(1 <= M <= 100,000), 그다음 줄에 M개의 수들이 주어지는데, 이 수들이 A 안에[ 존재하는지 알아내면 된다.
     * 모든 정수의 범위는 -231보다 크거나 같고 231보다 작다.
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] Narr = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int M = Integer.parseInt(bufferedReader.readLine());
        int[] Marr = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(Narr);
        System.out.println(Arrays.toString(Narr));
        /**
         * 이진탐색 필요한 것.
         * 1. 중앙값
         * 2. 중앙값의 중앙값으로 반복하는 재귀
         * */
        for (int i = 0; i < M; i++) {
            int find = Marr[i];
            System.out.println(binarySearch(Narr, find, 0, N - 1));
        }

    }

    public static int binarySearch(int[]arr, int find, int start, int end) {
        if(start > end) return 0;

        int mid = start + (end - start)/2;

        if(arr[mid] == find) {
            return 1;
        }

        if( arr[mid] < find ) {
            return binarySearch(arr, find, mid+1 , end);
        } else {
            return binarySearch(arr, find, start , mid-1);
        }

    }
}
