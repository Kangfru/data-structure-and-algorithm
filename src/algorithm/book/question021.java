package algorithm.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// boj1517
public class question021 {

    long result = 0;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(arr, temp, 0, n - 1);
        System.out.println(result);
    }

    private void mergeSort(int[] arr, int[] temp, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        mergeSort(arr, temp, start, mid);
        mergeSort(arr, temp, mid + 1, end);

        int k = start;
        int s = start;
        int e = mid + 1;
        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }
        while (s <= mid && e <= end) {
            if (temp[s] <= temp[e]) {
                arr[k++] = temp[s++];
            } else {
                result += e - k;
                arr[k++] = temp[e++];
            }
        }
        while (s <= mid) {
            arr[k++] = temp[s++];
        }
    }
    public static void main(String[] args) throws IOException {
        new question021().solution();
    }

}
