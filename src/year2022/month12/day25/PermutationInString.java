package year2022.month12.day25;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/permutation-in-string/?envType=study-plan&id=suan-fa-ru-men&plan=algorithms&plan_progress=yu2b416
 * 567.字符串的排列
 *
 * 滑动窗口
 */
public class PermutationInString {
    public static void main(String[] args) {
        System.out.println(new PermutationInString().checkInclusion("ab", "eidboaoo"));
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (int i = 0; i < s1.length(); ++i) {
            ++arr1[s1.charAt(i) - 'a'];
            ++arr2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(arr1, arr2)) {
            return true;
        }
        for (int i = s1.length(); i < s2.length(); ++i) {
            ++arr2[s2.charAt(i) - 'a'];
            --arr2[s2.charAt(i - s1.length()) - 'a'];
            if (Arrays.equals(arr1, arr2)) {
                return true;
            }
        }
        return false;
    }
}
