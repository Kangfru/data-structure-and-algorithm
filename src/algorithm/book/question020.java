package algorithm.book;

import java.io.*;

// boj 2751
public class question020 {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] temp = new int[n];
        mergeSort(arr, temp, 0, n - 1);
        for (int i = 0; i < n; i++) {
            bw.write(arr[i] + System.lineSeparator());
        }
        bw.flush();
        bw.close();
        br.close();
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
            if (temp[s] < temp[e]) {
                arr[k++] = temp[s++];
            } else {
                arr[k++] = temp[e++];
            }
        }
        while (s <= mid) {
            arr[k++] = temp[s++];
        }
    }

    public static void main(String[] args) throws IOException {
        new question020().solution();
    }

}
