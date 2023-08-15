package structure.sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 4, 9, 8, 10, 2, 7, 6};
//        for (int a: arr) {
//            System.out.println(a);
//        }
        quickSort(arr);
        for (int a: arr) {
            System.out.println(a);
        }
    }

    static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    static void quickSort(int[] arr, int start, int end) {
        int part = partition(arr, start, end);
        if (start < part - 1) {
            quickSort(arr, start, part - 1);
        }
        if (part < end) {
            quickSort(arr, part, end);
        }
    }

    static int partition(int[] arr, int start, int end) {
        int pivot = (start + end) / 2;
        while (start <= end) {
            while (arr[start] < arr[pivot]) start++;
            while (arr[pivot] < arr[end]) end--;
            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
