package binary;

/**
 * @author blissnmx
 * @date 12:50 2022/2/8
 * @description 输入一个字符串数组words，请计算当两个字符串words[i]和words[j]不包含相同字符时它们长度的乘积的最大值。
 * 如果没有不包含相同字符的一对字符串，那么返回0。
 * 假设字符串中只包含英语的小写字母。
 * 例如，输入的字符串数组words为["abcw", "foo", "bar", "fxyz","abcdef"]，数组中的字符串"bar"与"foo"没有相同的字符，它们长度的乘积为9。
 * "abcw"与" fxyz "也没有相同的字符，它们长度的乘积是16，这是不含相同字符的一对字符串的长度乘积的最大值。
 */
public class 单词长度的最大乘积 {


    /**
     * 使用32位的整数中的26位，记录每个单词中出现的字符，从a-z，右-左，单词出现则数位为1得到单词对应的整数，每个字符与其他字符做或运算，保留每个单词的数位的值
     * 两个单词若无重复字符，则二进制做与运算的结果为0
     * 时间复杂度：O(n^2)
     */
    public static int wordMaxLength(String[] words) {
        int result = 0;
        //记录每个单词转化为二进制后的整数
        int[] bitSums = new int[words.length];
        for (int i = 0; i < words.length; ++i) {
            for (char ch : words[i].toCharArray()) {
                bitSums[i] |= 1 << (ch - 'a');  // '|=' ==> bitSum = bitSum| **  1左移ch-'a'位，得到字符ch对应到26位的数位
            }
        }

        for (int i = 0; i < words.length; i++) {
            //固定一个单词与其他单词比较
            for (int j = i + 1; j < words.length; j++) {
                if ((bitSums[i] & bitSums[j]) == 0) { //不存在相同字符
                    int maxLen = words[i].length() * words[j].length();
                    result = Math.max(result, maxLen);
                }
            }
        }
        return result;
    }

    //问题可以归结为：判断两个字符是否有相同字符
    public static boolean checkTwoWordSameChar(String word1, String word2) {
        //用int型整数标识每个单词，整数转化为二进制是32位，从右到左记录字符出现与否，出现为1，得到单词对应的十进制整数，
        // 两个整数做与运算，若为0，则不存在相同字符
        int w1 = 0, w2 = 0;
        for (int i = 0; i < word1.length(); i++) {
            w1 = w1 | (1 << word1.charAt(i) - 'a');
        }
        for (int i = 0; i < word2.length(); i++) {
            w2 = w2 | (1 << word2.charAt(i) - 'a');
        }

        return (w1 & w2) == 0;
    }

    public static void main(String[] args) {
        //System.out.println("wordMaxLength = " + wordMaxLength(new String[]{"abc", "bcd", "efg", "higklm"}));
        System.out.println("checkTwoWordSameChar(\"abcde\",\"efhj\") = " + checkTwoWordSameChar("abcde", "t"));

    }
}
