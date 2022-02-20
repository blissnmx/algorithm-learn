package str;

import java.util.HashMap;

/**
 * @author  blissnmx
 * @date    17:28 2022/2/20
 * @description
 *输入两个字符串s和t，请找出s中包含t的所有字符的最短子字符串。
 * 例如输入s为字符串"ADDBANCAD"，t为字符串"ABC"，则s中包含字符'A'、'B'、'C'的最短子字符串是"BANC"。
 * 如果不存在符合条件的子字符串，返回空字符串""。如果存在多个符合条件的子字符串，返回任意一个。
 */
public class 含有所有字符的最短字符串 {

    /**
     * 思考：记录不重复字符的开始下标和结束下标
     * 用map记录字符出现与否与下标位置，如果字符出现过，则开始下标为原下标+1且取最大值（最后的位置）
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
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
        //System.out.println("noRepeatWordMaxLength  = " + noRepeatWordMaxLength("babccabcdes"));
    }
}
