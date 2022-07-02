package day20220627;

import java.util.HashMap;
import java.util.Map;

/**
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 *  
 *
 * 注意：
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 *输入：board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidSudoku {
    public static void main(String[] args) {

    }

    /**
     * 解法1
     * row[i][j]表示在第i行数字j出现的次数，如果大于1，那么数组无效
     * rol[i][j]表示在第i列数字j出现的次数，如果大于1，那么数组无效
     * box[i][j][k]表示在原大九宫格中的每一个小九宫格数字中k出现的次数，如果大于1，那么数组无效
     */
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][][] box = new int[3][3][9];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                char ch = board[i][j];
                if (ch != '.') {
                    row[i][ch - '0' - 1]++;
                    col[j][ch - '0' - 1]++;
                    box[i / 3][j / 3][ch - '0' - 1]++;
                    if (row[i][ch - '0' - 1] > 1 || col[j][ch - '0' - 1] > 1 || box[i / 3][j / 3][ch - '0' - 1] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
