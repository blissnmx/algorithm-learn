/**
 * @author ning_mx
 * @date 19:16 2022/3/10
 * @desc
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author ning_mx
 * @date 2022/3/10
 * *输入一个字符串，求该字符串中不含重复字符的最长连续子字符串的长度。
 * * 例如，输入字符串"babcca"，它最长的不含重复字符串的子字符串是"abc"，长度为3。。
 */
public class TestNoRepeatWordMaxLength {
    public static void main(String[] args) {
        String words = "babccabcdes";
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int start = 0, end = 0;
        for (int i = 0; i < words.length(); i++) {
            end = i;
            if (map.containsKey(words.charAt(i))) {
                start = Math.max(start, map.get(words.charAt(i)) + 1);
            }
            map.put(words.charAt(i), i);
            maxLen = Math.max(maxLen, (end - start) + 1);
        }
        System.out.println(maxLen);
    }
}
