/**
 * @author ning_mx
 * @date 11:17 2022/3/11
 * @desc
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author ning_mx
 * @date 2022/3/11
 */
public class TestContainerAllWordMinLength {
    public static void main(String[] args) {
        String strs = "ADDBANCAD";
        String trs = "ABC";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < trs.length(); i++) {
            map.put(trs.charAt(i), map.getOrDefault(trs.charAt(i), 0) + 1);
        }
        int count = trs.length();
        int left = 0, right = 0, minLen = Integer.MAX_VALUE;
        while (right < strs.length()) {
            char ch = strs.charAt(right);
            if (count != 0) {
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) - 1);
                    if (map.get(ch) == 0) {
                        count--;
                    }
                }
                right++;
            } else {
                //当count为0是，right往后移动一位，相当于长度=right-1 - left +1 =>right - left
                minLen = Math.min(minLen, right - left);
                char chl = strs.charAt(left);
                if (map.containsKey(chl)) {
                    map.put(chl, map.get(chl) + 1);
                    if (map.get(chl) == 1) {
                        count++;
                    }
                }
                left++;
            }
        }
        System.out.println(minLen);
    }
}
