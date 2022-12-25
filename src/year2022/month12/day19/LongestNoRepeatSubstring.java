package year2022.month12.day19;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestNoRepeatSubstring {
    public static void main(String[] args) {
        System.out.println(new LongestNoRepeatSubstring().lengthOfLongestSubstring1("aaaaaaaaaaaaa"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int windowLength = s.length();
        while (windowLength >= 1) {
            for (int start = 0, end = start + windowLength - 1; start < s.length() && end < s.length(); ++start, ++end) {
                String substring = s.substring(start, end + 1);
                Set<Character> set = new HashSet<>();
                for (int i = 0; i < substring.length(); ++i) {
                    set.add(substring.charAt(i));
                }
//                System.out.println(windowLength);
//                System.out.println(set);
                if (set.size() == windowLength) {
                    return windowLength;
                }
            }
            --windowLength;
        }
        return 1;
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }
        Set<Character> set = new HashSet<>();
        int right = -1;
        int res = 0;
        for (int left = 0; left < s.length(); ++left) {
            if (left != 0) {
                set.remove(s.charAt(left - 1));
            }
            while (right + 1 < s.length() && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                ++right;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
