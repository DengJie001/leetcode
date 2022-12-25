package year2022.month12.day16;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 *  
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MoveZero {
    public static void main(String[] args) {

    }

    /**
     * 指针1指向已处理好序列的头部 指针2指向已处理好序列的尾部
     * 每当指针2遇到非0值的时候 交换两个指针的值，并且两个指针同时右移 否则只将指针2右移
     * 由于指针2一直在寻找非0值并且与指针1交换，因此指针1左边都会是非0值 并且是按照原序列的顺序
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int tmp = nums[right];
                nums[right] = nums[left];
                nums[left] = tmp;
                ++left;
            }
            ++right;
        }
    }
}
