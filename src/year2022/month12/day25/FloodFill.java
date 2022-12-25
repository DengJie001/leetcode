package year2022.month12.day25;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://leetcode.cn/problems/flood-fill/?envType=study-plan&id=suan-fa-ru-men&plan=algorithms&plan_progress=yu2b416
 * 733.图像渲染
 */
public class FloodFill {
    public boolean[][] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] image = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                image[i][j] = scanner.nextInt();
            }
        }
        int[][] res = new FloodFill().floodFill(image, 0, 0, 2);
        for (int i = 0; i < res.length; ++i) {
            for (int j = 0; j < res[i].length; ++j) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        visited = new boolean[image.length][image[0].length];
        for (int i = 0; i < visited.length; ++i) {
            Arrays.fill(visited[i], false);
        }
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    public void dfs(int[][] image, int r, int c, int rawColor, int newColor) {
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length) {
            return;
        }
        if (visited[r][c] || image[r][c] != rawColor) {
            return;
        }
        visited[r][c] = true;
        image[r][c] = newColor;
        dfs(image, r - 1, c, rawColor, newColor);
        dfs(image, r + 1, c, rawColor, newColor);
        dfs(image, r, c - 1, rawColor, newColor);
        dfs(image, r, c + 1, rawColor, newColor);
    }
}
