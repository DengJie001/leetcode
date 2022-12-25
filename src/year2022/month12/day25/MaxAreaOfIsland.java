package year2022.month12.day25;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/max-area-of-island/?envType=study-plan&id=suan-fa-ru-men&plan=algorithms&plan_progress=yu2b416
 * 695.岛屿的最大面积
 */
public class MaxAreaOfIsland {
    public boolean visited[][];

    public int area = 0;
    public static void main(String[] args) {

    }

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < visited.length; ++i) {
            Arrays.fill(visited[i], false);
        }
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                dfs(grid, i, j);
                res = Math.max(res, area);
                area = 0;
            }
        }
        return res;
    }

    public void dfs(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) {
            return;
        }
        if (visited[r][c] || grid[r][c] == 0) {
            return;
        }
        visited[r][c] = true;
        ++area;
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}
