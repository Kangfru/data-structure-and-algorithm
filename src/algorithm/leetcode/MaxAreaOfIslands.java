package algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIslands {
    // bfs
    public static int[] dRow = { 0, 1, 0, -1};
    public static int[] dCol = { 1, 0, -1, 0};
    public static int maxAreaOfIsland(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    queue.offer(new int[]{i, j});
                    max = Math.max(max, bfs(grid, queue));
                }
            }
        }
        return max;
    }

    public static int bfs(int[][] grid, Queue<int[]> queue) {
        int count = 1;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            grid[current[0]][current[1]] = 0;
            for (int k = 0; k < 4; k++) {
                int nextRow = current[0] + dRow[k];
                int nextCol = current[1] + dCol[k];
                if (nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length && grid[nextRow][nextCol] == 1) {
                    count++;
                    queue.offer(new int[]{nextRow, nextCol});
                    grid[nextRow][nextCol] = 0;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        maxAreaOfIsland(new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}});
    }
}
