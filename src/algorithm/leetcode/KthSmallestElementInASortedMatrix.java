package algorithm.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {

//    public static int kthSmallest(int[][] matrix, int k) {
//        int[] mergeSortList = new int[matrix.length * matrix.length];
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix.length; j++) {
//                mergeSortList[matrix.length * i + j] = matrix[i][j];
//            }
//        }
//        Arrays.sort(mergeSortList);
//        return mergeSortList[k - 1];
//    }

    public static int kthSmallest(int[][] matrix, int k) {
        // priority queue (Min heap)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                pq.add(matrix[i][j]);
            }
        }
        while (!pq.isEmpty() && k > 1) {
            pq.poll();
            k--;
        }
        return pq.poll();
    }


    public static void main(String[] args) {
        System.out.println(kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}}, 8));
    }

}
