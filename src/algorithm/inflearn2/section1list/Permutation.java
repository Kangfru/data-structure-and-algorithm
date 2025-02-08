package algorithm.inflearn2.section1list;

import java.util.Arrays;

public class Permutation {

    // 길이가 n인 배열에 1부터 n까지 숫자가 중복 없이 한 번씩 들어있는 지 확인.
    // 중복 없는 경우 true, 아닐 경우 false
    // 배열의 길이는 10만 이하, 원소는 0 이상 10만 이하

    public static boolean solution(int[] arr) {
        int[] answer = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            answer[i] = i + 1;
        }
        Arrays.sort(arr);
        return Arrays.equals(arr, answer);
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 1, 3, 2};
        int[] arr2 = {4, 1, 3};
        System.out.println(solution(arr1));
        System.out.println(solution(arr2));
    }

}
