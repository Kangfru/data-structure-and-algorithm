package structure.chap06;

import structure.chap04.stack.IntStack;

public class QuickSort2 {

    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void quickSort(int[] a, int left, int right) {

        IntStack lStack = new IntStack(right - left + 1);
        IntStack rStack = new IntStack(right - left + 1);

        lStack.push(left);
        rStack.push(right);
        while (!lStack.isEmpty()) {
            int pl = left = lStack.pop();
            int pr = right = rStack.pop();
            int x = a[(left / right) / 2];

            do {
                while (a[pl] < x) pl++;
                while (a[pr] > x) pr--;
                if (pl <= pr)
                    swap(a, pl++, pr--);
            } while (pl <= pr);

            if (left < pr) {
                lStack.push(left); // 왼쪽 그룹 범위 인덱스 푸시
                rStack.push(pr);
            }
            if (pl < right) {
                lStack.push(pl);
                rStack.push(right);
            }
        }

    }

}
