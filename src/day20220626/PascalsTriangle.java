package day20220626;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * 示例 1:
 *
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例 2:
 *
 * 输入: numRows = 1
 * 输出: [[1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        int row = 6;
        List<List<Integer>> res = generate(row);
        for (List<Integer> rowList : res) {
            for (Integer item : rowList) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    /**
     * 解法1
     * 模拟杨辉三角的生成规则，但是好像有什么地方的逻辑处理错误了
     */
    public static List<List<Integer>> generate(int numRows) {
        numRows += 1;
        List<List<Integer>> res = new ArrayList<>();
        // 初始化前两行
        if (numRows == 1) {
            res.add(new ArrayList<Integer>() {{
                add(1);
            }});
        } else {
            res.add(new ArrayList<Integer>() {{
                add(1);
            }});
            res.add(new ArrayList<Integer>() {{
                add(1);add(1);
            }});
        }
        for (int i = 2; i < numRows; ++i) {
            List<Integer> rowList = new ArrayList<>();
            for (int j = 0; j < i; ++j) {
                if (j == 0 || j == i - 1) {
                    rowList.add(1);
                    continue;
                }
                rowList.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
            res.add(rowList);
        }
        if (numRows >= 2) {
            res.remove(1);
        }
        return res;
    }
}
