package year2022.month12.day16;

/**
 * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * 示例 2:
 *
 * 输入： s = "God Ding"
 * 输出："doG gniD"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 5 * 104
 * s 包含可打印的 ASCII 字符。
 * s 不包含任何开头或结尾空格。
 * s 里 至少 有一个词。
 * s 中的所有单词都用一个空格隔开。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseWordsInAStringIII {
    public static void main(String[] args) {
        System.out.println(new ReverseWordsInAStringIII().reverseWords("Let's take LeetCode contest"));

    }

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder resBuilder = new StringBuilder();
        for (String word : words) {
            char[] wordArr = word.toCharArray();
            int left = 0;
            int right = wordArr.length - 1;
            while (left <= right) {
                char tmp = wordArr[left];
                wordArr[left] = wordArr[right];
                wordArr[right] = tmp;
                ++left;
                --right;
            }
            resBuilder.append(wordArr).append(" ");
        }
        return resBuilder.substring(0, resBuilder.length() - 1);
    }
}
