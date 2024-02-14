package chapter5.이진탐색;

import com.sun.tools.javac.Main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class K번째_수 {
    /**
     *
     * 세준이는 크기가 N * N 인 배열 A를 만들었다.
     * 배열에 들어 있는 수는 A[i][j] = i * j 이다.
     * 이 수를 1차원 배열B에 넣으면 B의 크기는 N*N이 된다.
     * B를 오름차순 정렬했을 때 B[k]를 구하라
     *
     * 입력
     * 1번째 줄에 배열의 크기 N이 주어진다. N은 10^5보다 작거나 같은 자연수다.
     * 2번째 줄에 k가 주어진다. k는 min(10^9, N^2)보다 작거나 같은 자연수다.
     *
     * 출력
     * B[K]를 출력한다.
     *
     *  // 중앙값 정하기 :
     *         // 1  2  3  4  5  6  7  8  -- 1  * N
     *         // 2  4  6  8  10 12 14 16 -- 2  * N
     *         // 3  6  9  12 15 18 21 24 -- 3  * N
     *         // 4  8  12 16 20 24 28 32 -- 4  * N
     *         // 5  10 15 20 25 30 35 40 -- 5  * N
     *         // 6  12 18 24 30 36 42 48 -- 6  * N
     *         // 7  14 21 28 35 42 49 56 -- 7  * N
     *         // 8  16 24 32 40 48 56 64 -- 8  * N
     *         // 9  18 27 36 45 54 63 72 -- 9  * N
     *         // 10 20 30 40 50 60 70 80 -- 10 * N
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int K = Integer.parseInt(bufferedReader.readLine());

        long start = 1, end = K;
        long ans = 0;

        while (start <= end) {
            long middle = (start + end) / 2;
            long cnt = 0;
            for (int i = 1; i <= N; i++) {
                cnt += Math.min(middle / i, N);
            }
            if(cnt < K) {
                start = middle + 1;
            } else {
                ans = middle;
                end = middle - 1;
            }
        }
        System.out.println(ans);

    }
}
