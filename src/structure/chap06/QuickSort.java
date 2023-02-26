package structure.chap06;

import java.util.Scanner;

public class QuickSort {

    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void quickSort(int[] a, int left, int right) {
        int pl = left; // 왼쪽 커서
        int pr = right; // 우측 커서
        int x = a[(pl + pr) / 2]; // 피벗

        System.out.printf("a[%d] ~ a[%d] : {", left, right);
        for (int i = left; i < right; i++) {
            System.out.printf("%d , ", a[i]);
        }
        System.out.printf("%d}\n", a[right]);

        do {
            while (a[pl] < x) pl++;
            while (a[pr] > x) pr--;
            if (pl <= pr)
                swap(a, pl++, pr--);
        } while (pl <= pr);

        if (left < pr) quickSort(a, left, pr);
        if (pl < right) quickSort(a, pl, right);
    }

    static void quickSort(int[] a, int n) {
        quickSort(a, 0, n - 1);
    }

    static void quickSorta(int[] a) {
        int start = 0;
        int end = a.length - 1;
        quickSorta(a, start, end);
    }

    static void quickSorta(int[] a, int start, int end) {
        int pivot = (start + end) / 2;
        int pivotStart = start;
        int pivotEnd = end;

        while (pivotStart <= pivotEnd) {
            while (a[pivotStart] < a[pivot]) pivotStart++;
            while (a[pivotEnd] > a[pivot]) pivotEnd--;
            if (pivotStart <= pivotEnd) {
                swap(a, pivotStart, pivotEnd);
                pivotStart++;
                pivotEnd--;
            }
        }
        if (start < pivotEnd) quickSorta(a, start, pivotEnd);
        if (pivotStart > end) quickSorta(a, pivotStart, end);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("퀵 정렬");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }
//        quickSort(x, 0, nx - 1);
//        quickSort(x, nx);
        quickSorta(x);

        System.out.println("정렬결과");
        for (int i = 0; i < nx; i++) {
            System.out.println( x[i]);
        }
    }

}