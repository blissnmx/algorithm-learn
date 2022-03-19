/**
 * @author ning_mx
 * @date 14:29 2022/3/11
 * @desc
 */

/**
 * @author ning_mx
 * @date 2022/3/11
 *  *给定一个字符串，请问字符串里有多少回文连续子字符串？
 *  * 例如，字符串里"abc"有3个回文字符串，分别为"a"、"b"、"c"；
 */
public class TestCountSubStrPalineDrome {
    public static void main(String[] args) {
        String str = "aaa";
        int count = 0 ;
        for (int i = 0; i < str.length(); i++) {
            count += countPalineDrome(str, i, i);
            count += countPalineDrome(str, i, i + 1);
        }
        System.out.println(count);
    }

    public static int countPalineDrome(String str, int left, int right) {
        int count = 0 ;
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            count ++ ;
            left--;
            right ++ ;
        }
        return count ;
    }
}
