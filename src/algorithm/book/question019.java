package algorithm.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// boj 11004
public class question019 {

//    private void solution() throws IOException {
    // SIMPLE VERSION -> ELAPSED TIME : 2152
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int k = Integer.parseInt(st.nextToken());
//        int[] arr = new int[n];
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//        Arrays.sort(arr);
//        System.out.println(arr[k - 1]);
//        br.close();
//    }


    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(arr, k - 1);
        System.out.println(arr[k - 1]);
        br.close();
    }

    private void quickSort(int[] arr, int target) {
        quickSort(arr, 0, arr.length - 1, target);
    }

    private void quickSort(int[] arr, int start, int end, int target) {
        if (start < end) {
            int partition = partition(arr, start, end);
            if (partition == target) {
                return;
            } else if (partition < start) {
                quickSort(arr, start, partition - 1, target);
            } else {
                quickSort(arr, partition, end, target);
            }
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
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }

    public static void main(String[] args) throws IOException {
        new question019().solution();
    }

}
