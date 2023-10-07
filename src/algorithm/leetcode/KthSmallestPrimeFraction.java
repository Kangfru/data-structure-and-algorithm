package algorithm.leetcode;

import java.util.*;

public class KthSmallestPrimeFraction {

    public static class Pair {
        double fraction;
        int i;
        int j;

        public Pair(double fraction, int i, int j) {
            this.fraction = fraction;
            this.i = i;
            this.j = j;
        }
    }

    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Pair> fractionQueue = new PriorityQueue<>(Comparator.comparingDouble(o -> o.fraction));
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                double fraction = (double) arr[j] / (double) arr[i];
                fractionQueue.add(new Pair(fraction, i, j));
            }
        }
        for (int i = 0; i < k-1; i++) {
            fractionQueue.poll();
        }
        Pair answer = fractionQueue.poll();
        return new int[]{arr[answer.j], arr[answer.i]};
    }

    public static void main(String[] args) {
        kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3);
    }

}
