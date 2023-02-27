package structure.chap06;

public class HeapSort {

    // heap : '부모의 값이 자식의 값보다 항상 크거나 자식의 값이 부모의 값보다 항상 큼을 만족할 때.
    // HeapSort : 가장 큰 값이 루트에 위치하는 특징을 이용하는 정렬 알고리즘.
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void downHeap(int[] a, int left, int right) {
        // a[left] ~ a[right]를 힙으로 만든다.
        int temp = a[left]; // 루트
        int child; // 큰 값을 가진 노드
        int parent; // 부모
        for (parent = left; parent < (right + 1) / 2; parent = child) {
            int cl = parent * 2 + 1; // 왼쪽 자식
            int cr = cl + 1; // 오른쪽 자식
            child = (cr <= right && a[cr] > a[cl]) ? cr : cl; // 큰 값을 가진 노드를 자식에 대입.
            if (temp >= a[child])
                break;
            a[parent] = a[child];
        }
        a[parent] = temp;
    }

    static void heapSort(int[] a, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--) {
            // 배열 a를 힙상태로 만듦
            downHeap(a, i, n - 1); // a[i] ~ a[n-1]를 힙으로 만들기
        }

        for (int i = n - 1; i > 0; i--) {
            // 힙상태로 된 배열에서 루트의 가장 큰 값과 배열 마지막 요소로 만들고 다시 힙으로 만듦. (반복.)
            swap(a, 0, i); // 가장 큰 요소와 아직 정렬되지 않은 부분의 마지막 요소를 교환
            downHeap(a, 0, i - 1); // a[0] ~ a[i - 1]을 힙으로 만든다.
        }
    }

    static void heapifyAndHeapSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int child = i;
            do {
                int root = (child - 1) / 2;
                if (a[root] < a[child]) {
                    // 부모의 값보다 자식의 값이 더 크다면 위치를 바꿔준다.
                    swap(a, root, child);
                }
                child = root;
            } while (child != 0);
        }

        for (int i = n - 1; i >= 0; i--) {
            swap(a, 0, i); // 전체 루트의 노드와 가장 맨 뒤로 보내준다. (가장 큰 값을 맨 뒤로 보냄으로써 오름차순)
            int root = 0;
            int child;
            do {
                child = 2 * root + 1;
                // 자식 중에 큰 값 찾기
                if (child < i - 1 && a[child] < a[child + 1]) {
                    child++;
                }
                // 루트 보다 자식이 더 크다면 교환
                if (child < i && a[root] < a[child]) {
                    swap(a, root, child);
                }
                root = child;
            } while (child < i);
        }
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
        heapifyAndHeapSort(arr, arr.length);
        printArray(arr);
    }

}
