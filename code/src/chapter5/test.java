package chapter5;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6};

        Arrays.stream(numbers).parallel().forEach(number->{
            System.out.println(number);
        });
    }
}
