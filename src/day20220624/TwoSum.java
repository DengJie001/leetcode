package day20220624;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *  示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[] {3,2,4};
        int target = 6;
        int[] res = twoSum(nums, target);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    /**
     * 解法1（另外一种O(N)的解法就是直接双循环）
     * 由于题目中说明只存在唯一解，则可以从前往后遍历，用target - nums[i]作为key去map中查找
     * 如果找不到则证明暂时不存在解
     * 若找到了，value则是下标，这时候只需要返回两个下标即可
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; ++i) {
            Integer num = map.get(target - nums[i]);
            if (num == null) {
                map.put(nums[i], i);
                continue;
            } else {
                res[0] = num;
                res[1] = i;
                break;
            }
        }
        return res;
    }
}
