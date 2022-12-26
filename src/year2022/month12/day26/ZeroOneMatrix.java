package year2022.month12.day26;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 01矩阵
 * https://leetcode.cn/problems/01-matrix/?envType=study-plan&id=suan-fa-ru-men&plan=algorithms&plan_progress=yu2b416
 */
public class ZeroOneMatrix {
    /**
     * 分别维护当前点位的上下左右四个位置
     */
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int[][] res = new ZeroOneMatrix().updateMatrix(matrix);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] res = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < res.length; ++i) {
            Arrays.fill(res[i], 0);
            Arrays.fill(visited[i], false);
        }
        // 所有的0 放入队列中
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (mat[i][j] == 0) {
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        // BFS遍历所有非0节点 计算最近0的位置
        while (!queue.isEmpty()) {
            int[] zeroLocation = queue.poll();
            // 当前0的位置
            int r = zeroLocation[0];
            int c = zeroLocation[1];
            // 该0位置上下左右四个方向寻找1的位置
            for (int i = 0; i < dirs.length; ++i) {
                int nextRow = r + dirs[i][0];
                int nextCol = c + dirs[i][1];
                // 该点若不出界且未被访问过 则该点一定是1
                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && !visited[nextRow][nextCol]) {
                    res[nextRow][nextCol] = res[r][c] + 1;
                    // 由于不是所有的1都与0相邻 因此也需要将访问过的1 放入队列当中 以计算不与0相邻的1最近的0的位置
                    queue.offer(new int[]{nextRow, nextCol});
                    visited[nextRow][nextCol] = true;
                }
            }
        }
        return res;
    }
}
