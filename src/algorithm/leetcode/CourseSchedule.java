package algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // 위상정렬 문제임. 위상정렬 복습할 것.
        Queue<Integer> queue = new LinkedList<>();
        int[] preCount = new int[numCourses];
        for (int[] ints : prerequisites) {
            preCount[ints[0]]++;
        }
        for(int i = 0; i < numCourses; i++){
            if (preCount[i] == 0){
                queue.add(i);
            }
        }
        int noPreCount = queue.size();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == current) {
                    preCount[prerequisite[0]]--;
                    if (preCount[prerequisite[0]] == 0) {
                        noPreCount++;
                        queue.add(prerequisite[0]);
                    }
                }
            }
        }
        return noPreCount == numCourses;
    }

    public static void main(String[] args) {
        canFinish(2, new int[][]{{1, 0}});
    }

}
