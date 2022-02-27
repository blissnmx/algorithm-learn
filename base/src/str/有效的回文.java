/**
 * @author ning_mx
 * @date 11:47 2022/2/22
 * @desc
 */
package str;

/**
 * @author blissnmx
 * @date 2022/2/22
 * 给定一个字符串，请判断它是不是一个回文字符串。我们只需要考虑字母或者数字字符，并忽略大小写。
 * 例如，"A man, a plan, a canal: Panama"是一个回文字符串，而"race a car"不是。
 */
public class 有效的回文 {

    public static boolean isPalineDrome(String str) {
        int l = 0 ,r = str.length()-1;
        while(l < r ){
            if (str.charAt(l) == str.charAt(r)) {
                l++;
                r--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("isPalineDrome() = " + isPalineDrome("abcba"));
    }
}
