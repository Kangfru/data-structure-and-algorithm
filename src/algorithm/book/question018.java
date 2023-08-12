package algorithm.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// boj 11399
public class question018 {

    private void solution() throws IOException {
        // N의 최댓값이 1000 이기에 정렬 알고리즘 아무거나 사용 가능.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] time = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(time);
        int[] sigma = new int[n];
        int currentSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum += time[i];
            sigma[i] = currentSum;
        }
        System.out.println(Arrays.stream(sigma).sum());
    }

    private void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int target = arr[i];
            int j = i - 1;
            while (j >= 0 && target < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = target;
        }
    }

    private void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int start, int end) {
        int partIndex = partition(arr, start, end);
        if (start < partIndex - 1) {
            quickSort(arr, start, partIndex - 1);
        }
        if (partIndex < end) {
            quickSort(arr, partIndex, end);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];
        while (start <= end) {
            while (arr[start] < pivot) start++;
            while (arr[end] > pivot) end--;
            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    private void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }



    public static void main(String[] args) throws IOException {
        new question018().solution();
    }
}
