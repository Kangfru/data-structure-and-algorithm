package structure.sort;

public class MergeSort {

    static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    static void mergeSort(int[] arr, int[] temp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, temp, start, mid);
            mergeSort(arr, temp, mid + 1, end);
            int tempIndex = start;
            int part1Index = start;
            int part2Index = mid + 1;
            while (part1Index <= mid && part2Index <= end) {
                if (arr[part1Index] < arr[part2Index]) {
                    temp[tempIndex++] = arr[part1Index++];
                } else {
                    temp[tempIndex++] = arr[part2Index++];
                }
            }
            while (part1Index <= mid) {
                temp[tempIndex++] = arr[part1Index++];
            }
            while (part2Index <= end) {
                temp[tempIndex++] = arr[part2Index++];
            }
            for (int i = start; i <= end; i++) {
                arr[i] = temp[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 4, 9, 8, 10, 2, 7, 6};
//        int[] arr = {4, 2, 3, 1};
        mergeSort(arr);
        for (int a: arr) {
            System.out.println(a);
        }
    }

}
