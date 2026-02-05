package algorithm.inflearn4;

/**
 * boj 2750
 * 1000 개라 그냥 뭐든 sort 알고리즘(Arrays.sort 걍 써도 됨)=해도 되나 다양한 Sort로 풀이해보기
 */
public class solution15 {

    public void insertionSort(int[] numbers) {
        // O(n^2)
        for (int i = 1; i < numbers.length; i++) {
            int key = numbers[i];
            int j = i - 1;
            while (j >= 0 && numbers[j] > key) {
                numbers[j + 1] = numbers[j];
                j--;
            }
            numbers[j + 1] = key;
        }
    }

    public void bubbleSort(int[] numbers) {
        // O(n^2)
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    // O(n^2) - 매 반복마다 최솟값을 찾아 앞으로 보냄
    public void selectionSort(int[] numbers) {
        // TODO
    }

    // O(n log n) - 반으로 나누고, 정렬하며 합침
    public void mergeSort(int[] numbers, int left, int right) {
        // TODO
    }

    private void merge(int[] numbers, int left, int mid, int right) {
        // TODO
    }

    // O(n log n) 평균 - pivot 기준으로 좌우 분할
    public void quickSort(int[] numbers, int left, int right) {
        // TODO
    }

    private int partition(int[] numbers, int left, int right) {
        // TODO
        return -1;
    }

    // O(n log n) - 최대힙 구성 후 하나씩 꺼냄
    public void heapSort(int[] numbers) {
        // TODO
    }

    private void heapify(int[] numbers, int n, int i) {
        // TODO
    }

    // O(n + k) - 값의 범위가 작을 때 유용, 비교 없이 정렬
    public void countingSort(int[] numbers) {
        int min = numbers[0], max = numbers[0];
        for (int number : numbers) {
            min = Math.min(min, number);
            max = Math.max(max, number);
        }
        int[] counting = new int[max - min + 1];
        for (int number : numbers) {
            counting[number - min]++;
        }
        int idx = 0;
        for (int i = 0; i < counting.length; i++) {
            for (int j = 0; j < counting[i]; j++) {
                numbers[idx++] = i + min;
            }
        }
    }

    public static void main(String[] args) {

    }

}
