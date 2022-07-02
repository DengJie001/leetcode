package day20220625;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，
 * 应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 *
 * 示例 2:
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntersectionofTwoArraysII {
    public static void main(String[] args) {
        int[] nums1 = new int[] { 4, 9, 5 };
        int[] nums2 = new int[] { 9, 4, 9, 8, 4 };
        int[] res = intersect(nums1, nums2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    /**
     * 解法1 双指针
     * 先对两个数组进行升序排序
     * 定义两个指针分别指向nums1和nums2的头部，同时比较两个指针指向的值，如果相同则放入结果数组中
     * 如果p1指向的值大于p2指向的值，则将p2后移；反之则将p1后移
     * 时间复杂度取决于排序的时间复杂度
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        int p1 = 0;
        int p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                list.add(nums1[p1]);
                ++p1;
                ++p2;
            } else if (nums1[p1] > nums2[p2]) {
                ++p2;
            } else if (nums1[p1] < nums2[p2]) {
                ++p1;
            }
        }
        int[] res = new int[list.size()];
        for (Integer item : list) {
            res[idx++] = item;
        }
        return res;
    }
}
