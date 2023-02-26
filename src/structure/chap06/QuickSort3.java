package structure.chap06;

// 퀵 정렬 인덱스 리턴 버전
public class QuickSort3 {

    static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    static void quickSort(int[] arr, int start, int end) {
        int part2Index = partition(arr, start, end);
        if (start < part2Index -1)
            quickSort(arr, start, part2Index - 1);
        if (part2Index < end)
            quickSort(arr, part2Index, end);
    }

    static int partition(int[] arr, int start, int end) {
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

    static void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }

    static void printArray(int[] arr) {
        for (int a : arr) {
            System.out.printf("%d, ", a);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {0, 5, 4, 1, 8, 9, 6, 3};
        printArray(arr);
        quickSort(arr);
        printArray(arr);

    }

}
