/**
 * @author ning_mx
 * @date 11:47 2022/2/22
 * @desc
 */
package str;

/**
 * @author blissnmx
 * @date 2022/2/22
 * 给定一个字符串，请判断如果最多从字符串中删除一个字符能不能得到一个回文字符串。
 * 例如，如果输入字符串"abca"，由于删除字符'b'或者'c'就能得到一个回文字符串，因此输出为true。
 */
public class 最多删除一个字符得到回文 {

    /**
     * 遍历字符串得到不相同的左边字符下标和右边字符下标，分别判断删除不同字符后的子串是否是回文
     *
     * @param str
     * @return
     */
    public static boolean isRemoveCharToGetPalineDrome(String str) {
        int l = 0, r = str.length() - 1;
        //得到不同字符的下标
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                break;
            } else {
                l++;
                r--;
            }
        }
        //判断左边和右边的字符跳过之后是否是回文
        return isPalineDrome(str.substring(l + 1, r + 1)) || isPalineDrome(str.substring(l, r));
    }

    public static boolean isPalineDrome(String str) {
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) == str.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("isRemoveCharToGetPalineDrome(\"abdba\") = " + isRemoveCharToGetPalineDrome("abdbat"));
    }
}
