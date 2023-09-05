package algorithm.review;

import java.io.*;

// 백준 2750 오름차순 정렬
public class question015 {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        quickSort(arr);
        for (int i = 0; i < count; i++) {
            System.out.println(arr[i]);
        }
    }

    private void bubbleSort(int[] arr) {
        // O(n^2)
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // quickSort
    private void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int pivot = arr[(start + end) / 2];
        int indexS = start;
        int indexE = end;
        do {
            while (arr[indexS] < pivot) indexS++;
            while (arr[indexE] > pivot) indexE--;
            if (indexS <= indexE) {
                swap(arr, indexS, indexE);
                indexS++;
                indexE--;
            }
        } while (indexS <= indexE);
        if (start < indexE) quickSort(arr, start, indexE);
        if (indexS > end) quickSort(arr, indexS, end);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // mergeSort
    public static void main(String[] args) throws IOException {
        new question015().solution();
    }

}
