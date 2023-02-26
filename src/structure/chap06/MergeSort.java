package structure.chap06;

public class MergeSort {

    static int[] buff; // 작업용 배열

    static void __mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int i; // 현재 가리키는 배열 인덱스
            int center = (left + right) / 2;
            int p = 0;
            int j = 0;
            int k = left;

            __mergeSort(a, left, center); // 배열 앞 부분 병합 정렬
            __mergeSort(a, center + 1, right); // 배열 뒷 부분 병합 정렬

            for (i = left; i <= center; i++) {
                buff[p++] = a[i];
            }
            while (i <= right && j < p) {
                a[k++] = (buff[j] <= a[i]) ? buff[j++] : a[i++];
            }
            while (j < p)
                a[k++] = buff[j++];
        }
    }

    static void mergeSort(int[] a, int n) {
        buff = new int[n];
        __mergeSort(a, 0, n - 1);
        buff = null;
    }

    static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        _mergeSort(arr, temp, 0, arr.length - 1);
    }

    static void _mergeSort(int[] arr, int[] temp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            _mergeSort(arr, temp, start, mid);
            _mergeSort(arr, temp, mid + 1, end);
            merge(arr, temp, start, mid, end);
        }
    }

    static void merge(int[] arr, int[] temp, int start, int mid, int end) {

        for (int i = start; i <= end; i++) {
            temp[i] = arr[i]; // 임시 배열로 복사
        }
        int part1 = start; // a 배열의 첫 인덱스
        int part2 = mid + 1; // b 배열의 첫 인덱스
        int index = start;

        while (part1 <= mid && part2 <= end) {
            if (temp[part1] <= temp[part2]) {
                arr[index] = temp[part1];
                part1++;
            } else {
                arr[index] = temp[part2];
                part2++;
            }
            index++;
        }

        for (int i = 0; i <= mid - part1; i++) {
            arr[index + i] = temp[part1 + i];
        }
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d, ", arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {8,5,2,104,5,2,7,4,3};
        printArray(arr);
        mergeSort(arr);
        printArray(arr);
    }

}

