package day20221212;

import java.util.Scanner;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(line));
    }

    public String longestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }
        int maxLen = s.length();
        for (int i = 0; i < maxLen; ++i) {
            int start = 0;
            int end = maxLen - i - 1;
            while (end < s.length()) {
                String substring = s.substring(start, end + 1);
                ++end;
                ++start;
                if (isPalindromic(substring)) {
                    return substring;
                }
            }
        }
        return String.valueOf(s.charAt(0));
    }

    public boolean isPalindromic(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; ++i) {
            if (chars[i] != chars[chars.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
