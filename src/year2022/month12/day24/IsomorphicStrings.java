package year2022.month12.day24;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * https://leetcode.cn/problems/isomorphic-strings/
 * 205.同构字符串
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(new IsomorphicStrings().isIsomorphic("paper", "title"));
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sMapT = new HashMap<>();
        Map<Character, Character> tMapS = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); ++i) {
            char sCh = s.charAt(i);
            char tCh = t.charAt(i);
            if (sMapT.containsKey(sCh)) {
                Character cacheChar = sMapT.get(sCh);
                if (cacheChar != tCh) {
                    return false;
                }
            } else {
                sMapT.put(sCh, tCh);
            }
            if (tMapS.containsKey(tCh)) {
                Character cacheChar = tMapS.get(tCh);
                if (cacheChar != sCh) {
                    return false;
                }
            } else {
                tMapS.put(tCh, sCh);
            }
        }
        return true;
    }
}
