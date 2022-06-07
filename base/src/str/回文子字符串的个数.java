/**
 * @author ning_mx
 * @date 11:47 2022/2/22
 * @desc
 */
package str;

/**
 * @author blissnmx
 * @date 2022/2/22
 * 给定一个字符串，请问字符串里有多少回文连续子字符串？
 * 例如，字符串里"abc"有3个回文字符串，分别为"a"、"b"、"c"；
 * 而字符串"aaa"里有6个回文子字符串，分别为"a"、"a"、"a"、"aa"、"aa"和"aaa"。
 */
public class 回文子字符串的个数 {

    /**
     * 思考：求得所有子字符串是否是回文，则可以固定一个字符串，使用双指针，向左右延伸，判断延伸后是否为回文
     * 两种情况：奇数以一个值为中心、偶数以两个值为中心
     * 时间复杂度：O(N2)
     */
    public static int countSubStrPalineDrome(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count += isPalineDromeAndCount(str, i, i);
            count += isPalineDromeAndCount(str, i, i + 1);
        }
        return count;
    }

    public static int isPalineDromeAndCount(String str, int start, int end) {
        int count = 0;
        while (start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)) {
            count++;
            start--;
            end++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("countSubStrPalineDrome = " + countSubStrPalineDrome("aaa"));
    }
}
