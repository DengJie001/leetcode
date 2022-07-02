package day20220626;

/**
 * 在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
 *
 * 给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
 *
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
 *
 * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 * 输入：mat = [[1,2],[3,4]], r = 1, c = 4
 * 输出：[[1,2,3,4]]
 *
 * 输入：mat = [[1,2],[3,4]], r = 2, c = 4
 * 输出：[[1,2],[3,4]]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reshape-the-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReshapeTheMatrix {
    public static void main(String[] args) {
        int[][] mat = new int[][] { {1, 2}, {3, 4} };
        int r = 1;
        int c = 4;
        int[][] res = matrixReshape2(mat, r, c);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 解法1 简单粗暴
     * 能够被重塑的矩阵必要条件是：原矩阵元素个数和新矩阵元素个数相同
     * 先将原矩阵按照行存储到新的一维数组中
     * 然后按照r，c进行循环将数据写入到新矩阵当中
     */
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        // 如果原矩阵的元素个数小于重塑后矩阵需求的元素个数 则认为操作不合理
        if (mat[0].length * mat.length != r * c) {
            return mat;
        }
        int[][] res = new int[r][c];
        int[] temp = new int[r * c];
        int idxTemp = 0;
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[i].length; ++j) {
                temp[idxTemp++] = mat[i][j];
            }
        }
        idxTemp = 0;
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                res[i][j] = temp[idxTemp++];
            }
        }
        return res;
    }

    /**
     * 解法2
     * 判断是否可重塑的方法不变
     * 将原矩阵在逻辑上映射到一个一维数组中，
     * 然后将这个一维数组根据行列关系映射到新的矩阵中
     */
    public static int[][] matrixReshape2(int[][] mat, int r, int c) {
        if (mat.length * mat[0].length != r * c) {
            return mat;
        }
        int[][] res = new int[r][c];
        for (int i = 0; i < mat.length * mat[0].length; ++i) {
            res[i / c][i % c] = mat[i / mat[0].length][i % mat[0].length];
        }
        return res;
    }
}
