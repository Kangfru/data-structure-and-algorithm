package algorithm.leetcode;

public class NumberOfIslands {

    private static final int[] dx = {-1, 0, 1, 0};

    private static final int[] dy = {0, -1, 0, 1};


    public int numIslands(char[][] grid) {
        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    answer++;
                    dfs(i, j, grid);
                }
            }
        }
        return answer;
    }

    public void dfs(int x, int y, char[][] grid) {
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1') {
            grid[x][y] = '0';
            dfs(x, y+1, grid);
            dfs(x, y-1, grid);
            dfs(x+1, y, grid);
            dfs(x-1, y, grid);
        }
    }

}
