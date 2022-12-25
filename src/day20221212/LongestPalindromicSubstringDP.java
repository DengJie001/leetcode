package day20221212;

public class LongestPalindromicSubstringDP {
    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstringDP().longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int maxLen = 1;
        int start = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); ++i) {
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();
        for (int l = 2; l <= s.length(); ++l) {
            for (int i = 0; i < s.length(); ++i) {
                int j = l + i - 1;
                if (j >= s.length()) {
                    break;
                }
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
