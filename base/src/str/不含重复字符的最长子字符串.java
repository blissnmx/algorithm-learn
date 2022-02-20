package str;

import java.util.HashMap;

/**
 * @author  blissnmx
 * @date    17:50 2022/2/20
 * @description
 *输入一个字符串，求该字符串中不含重复字符的最长连续子字符串的长度。
 * 例如，输入字符串"babcca"，它最长的不含重复字符串的子字符串是"abc"，长度为3。。
 */
public class 不含重复字符的最长子字符串 {

    /**
     * 思考：记录不重复字符的开始下标和结束下标
     * 用map记录字符出现与否与下标位置，如果字符出现过，则开始下标为原下标+1且取最大值（最后的位置）
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public static int noRepeatWordMaxLength(String words) {
        int result = 0 ,startIdx = 0,endIdx = 0;
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < words.length(); i++) {
            endIdx = i ;
            if (charMap.containsKey(words.charAt(i))) {
                startIdx = Math.max(startIdx,charMap.get(words.charAt(i))+1);
            }
            charMap.put(words.charAt(i), i);
            result = Math.max(result, endIdx - startIdx + 1);
        }

        return  result;
    }

    public static void main(String[] args) {
        System.out.println("noRepeatWordMaxLength  = " + noRepeatWordMaxLength("babccabcdes"));
    }
}
