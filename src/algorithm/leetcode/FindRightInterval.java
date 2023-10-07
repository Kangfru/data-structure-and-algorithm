package algorithm.leetcode;

import java.util.TreeMap;

public class FindRightInterval {

    // brute force way
//    public static int[] findRightInterval(int[][] intervals) {
//        int[] rightIntervals = new int[intervals.length];
//        for (int i = 0; i < intervals.length; i++) {
//            boolean flag = false;
//            for (int j = 0; j < intervals.length; j++) {
//                if (i == j) continue;
//                if (intervals[i][1] <= intervals[j][0]) {
//                    rightIntervals[i] = intervals[j][0] < intervals[rightIntervals[i]][0] ? rightIntervals[i] : j;
//                    flag = true;
//                }
//            }
//            if (!flag) rightIntervals[i] = -1;
//        }
//        return rightIntervals;
//    }

    public static int[] findRightInterval(int[][] intervals) {
        // java tree map 이용
        TreeMap<Integer, Integer> rightIntervals = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            rightIntervals.put(intervals[i][0], i);
        }
        int[] answer = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            Integer minStart = rightIntervals.ceilingKey(intervals[i][1]);
            answer[i] = minStart == null ? -1 : rightIntervals.get(minStart);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] answer = findRightInterval(new int[][]{{1,4},{2,3},{3,4}});
        for (int i : answer) {
            System.out.println(i);
        }
    }

}
