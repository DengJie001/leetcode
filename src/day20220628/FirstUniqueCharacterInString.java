package day20220628;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: 0
 * 示例 2:
 *
 * 输入: s = "loveleetcode"
 * 输出: 2
 * 示例 3:
 *
 * 输入: s = "aabb"
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FirstUniqueCharacterInString {
    public static void main(String[] args) {
        System.out.println(new FirstUniqueCharacterInString().firstUniqChar("leetcode"));
    }

    /**
     * 解法1 双循环暴力解法
     */
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        boolean flag = true;
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length; ++j) {
                if (i == j) {
                    continue;
                }
                if (chars[i] == chars[j]) {
                    flag = false;
                    break;
                }
                flag = true;
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 解法2 两次单循环
     * 第一次遍历时使用hash表记录字符出现的次数，第二次遍历时在hash表中查找该字符出现的次数，如果是1的话则返回，找不到的话则返回-1
     */
    public int firstUniqChar1(String s) {
        Map<Character, Integer> record = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            record.put(s.charAt(i), record.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (record.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
