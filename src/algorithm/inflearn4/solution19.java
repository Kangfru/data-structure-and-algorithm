package algorithm.inflearn4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * boj 11004
 */
public class solution19 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(numbers, 0, numbers.length - 1);
        System.out.println(numbers[k - 1]);
    }

    public static void quickSort(int[] numbers, int left, int right) {
        int partitionIndex = partition(numbers, left, right);
        if (left < partitionIndex - 1) {
            quickSort(numbers, left, partitionIndex - 1);
        }
        if (partitionIndex < right) {
            quickSort(numbers, partitionIndex, right);
        }
    }

    public static int partition(int[] numbers, int left, int right) {
        int pivot = numbers[(right + left) / 2];
        // 중간 값을 피봇으로
        while (left <= right) {
            while (numbers[left] < pivot) left++; // 피봇 보다 큰 수가 나올 떄 까지 left의 인덱스를 옮긴다.
            while (numbers[right] > pivot) right--; // 피봇보다 작은 수가 나올 때 까지 right의 인덱스를 옮긴다.
            if (left <= right) {
                int temp = numbers[left];
                numbers[left] = numbers[right];
                numbers[right] = temp;
                left++;
                right--;
            }
        }
        return left; // 피봇이 나눠진 경계선
    }

}
