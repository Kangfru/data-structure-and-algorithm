package algorithm.inflearn2.section1list;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class MaxIndex {

    // 최대값 인덱스 구하기
    // 주어진 입력 중 최대값을 구하고, 최대값이 위치하는 index의 위치를 반환하시오


    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 4, 5, 2, 1};
        for (int i : solution(arr)) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        return IntStream.range(0, arr.length)
                .filter(i -> arr[i] == max)
                .toArray();
    }

}
