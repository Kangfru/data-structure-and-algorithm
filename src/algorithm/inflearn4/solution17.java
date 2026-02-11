package algorithm.inflearn4;

import java.util.Scanner;

/**
 * boj1427
 */
public class solution17 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numbers = sc.nextLine();
        int[] arr = new int[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(numbers.charAt(i)));
        }

        // Selection Sort
        // 최소 또는 최대를 찾아 위치를 옮김.
        for (int i = 1; i < numbers.length(); i++) {
            int max = i;
            for (int j = i + 1; j < numbers.length(); j++) {
                if (arr[j] > arr[max]) max = j;
            }
            if (arr[i] < arr[max]) {
                int temp = arr[i];
                arr[i] = arr[max];
                arr[max] = temp;
            }
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
