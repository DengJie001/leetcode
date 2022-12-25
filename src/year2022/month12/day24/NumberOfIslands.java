package year2022.month12.day24;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://leetcode.cn/problems/number-of-islands/
 * 200.岛屿数量
 */
public class NumberOfIslands {
    public boolean[][] visited;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        scanner.nextLine();
        char[][] grid = new char[row][col];
        for (int i = 0; i < row; ++i) {
            String line = scanner.nextLine();
            grid[i] = line.replaceAll(" ", "").toCharArray();
        }
        System.out.println(new NumberOfIslands().numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < visited.length; ++i) {
            Arrays.fill(visited[i], false);
        }
        int res = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    ++res;
                    dfs(i, j, grid);
                }
            }
        }
        return res;
    }

    public void dfs(int r, int c, char[][] grid) {
        // 出界
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) {
            return;
        }
        // 被访问过 或 不是陆地
        if (visited[r][c] || grid[r][c] == '0') {
            return;
        }
        // 标记该陆地已经访问过
        visited[r][c] = true;
        // 访问该点上方的第一个点
        dfs(r - 1, c, grid);
        // 访问该点下方的第一个点
        dfs(r + 1, c, grid);
        // 访问该点左边的第一个点
        dfs(r, c - 1, grid);
        // 访问该店右边的第一个点
        dfs(r, c + 1, grid);
    }
}
