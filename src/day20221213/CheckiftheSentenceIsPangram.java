package day20221213;

import java.util.ArrayList;
import java.util.List;

/**
 * 全字母句 指包含英语字母表中每个字母至少一次的句子。
 *
 * 给你一个仅由小写英文字母组成的字符串 sentence ，请你判断 sentence 是否为 全字母句 。
 *
 * 如果是，返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：sentence = "thequickbrownfoxjumpsoverthelazydog"
 * 输出：true
 * 解释：sentence 包含英语字母表中每个字母至少一次。
 * 示例 2：
 *
 * 输入：sentence = "leetcode"
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= sentence.length <= 1000
 * sentence 由小写英语字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/check-if-the-sentence-is-pangram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckiftheSentenceIsPangram {
    public static void main(String[] args) {

    }

    public boolean checkIfPangram(String sentence) {
        List<String> alpha = new ArrayList<String>() {{
            add("a");add("b");add("c");add("d");add("e");
            add("f");add("g");add("h");add("i");add("j");
            add("k");add("l");add("m");add("n");add("o");
            add("p");add("q");add("r");add("s");add("t");
            add("u");add("v");add("w");add("x");add("y");add("z");
        }};
        char[] chars = sentence.toCharArray();
        for (String item : alpha) {
            if (!sentence.contains(item)) {
                return false;
            }
        }
        return true;
    }
}
