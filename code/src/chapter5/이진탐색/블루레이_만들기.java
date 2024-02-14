package chapter5.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class 블루레이_만들기 {
    /**
     * 강토는 자신의 기타 레슨 동영상을 블루레이로 만들어 판매하려고 한다.
     * 블루레이는 총 N개의 레슨이 들어가는데, 블루레이를 녹화할 때 레슨의 순서가 바뀌면 안된다.
     * 순서가 뒤바뀔 때는 레슨의 흐름이 끊겨 학생들이 혼란에 빠질 수 있기 때문이다.
     * 즉, i,j번 레슨을 같은 블루레이에 녹화하려면 I와 j 사이의 모든 레슨도 같은 블루레이에 녹화해야한다.
     *
     * 강토는 이 블루레이가 얼마나 팔릴지 아직 알 수 없어 제작 개수를 가급적 줄이려고 한다.
     * 강토는 고민 끝에 M개의 블루레이에 모든 기타 레슨 동영상을 녹화하기로 했다.
     * 이때 블루레이의 크기 ( 녹화할 수 있는 길이는 최소로 하고, M개의 블루레이는 모두 같은 크기로 만들려고 한다.
     *
     * 강토의 각 레슨의 길이가 분 단위 자연수로 주어질 때 가능한 블루레이의 크기 중 최솟값을 구하는
     * 프로그램을 작성하시오.
     *
     *
     * 입력
     * 1번째 줄에 레슨의 수 N(1 <= N <= 100,000) 과 M ( 1 <= M <= N ),
     * 2번째 줄에 강토의 기타 레슨의 길이가 레슨 순서대로 분 단위로(자연수)로 주어진다. 각 레슨의 길이는 10,000분을 넘지 않는다.
     *
     **/
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] firstLine = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int lesson = firstLine[0];
        int blulay = firstLine[1];

        int[] videoArr = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int videoAverage = Arrays.stream(videoArr).sum()/blulay;


        int size = videoAverage;
        int j = -1;

        while (true){

            for (int i = 0; i < blulay; i++){

                int length = 0;
                while (length < size && j < videoArr.length - 1){
                    j++;
                    length += videoArr[j];
                }

                if(length > size){
                    j--;
                }
            }

            if(j == videoArr.length - 1){
                break;
            } else {
                j = -1;
                size++;
            }
            
        }

        System.out.println(size);
    }
}
