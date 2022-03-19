/**
 * @author ning_mx
 * @date 15:30 2022/3/14
 * @desc
 */

/**
 * @author ning_mx
 * @date 2022/3/14
 */
public class TestIsRemoveCharToGetPalineDrome {

    /**
     * 判断一个字符串删除一个字符后是否是回文
     * @param args
     */
    public static void main(String[] args) {
        String str = "acbcaca";
        //找到不相同的字符的下标
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                break;
            }
            left ++ ;
            right -- ;
        }
        String subStrLeft = "";
        String subStrRight ="" ;
        //删除下标为left或者right的字符后，判断是否是回文
        if (left == 0) {
            subStrLeft = str.substring(1, str.length());
        }else{
            subStrLeft = str.substring(0, left) + str.substring(left + 1, str.length());
        }
        if (right == str.length() - 1) {
            subStrRight = str.substring(0, right);
        }else{
            subStrRight= str.substring(0,right) + str.substring( right+1, str.length());
        }
        boolean b = isPalineDrome(subStrLeft) || isPalineDrome(subStrRight);
        System.out.println(b);
    }

    private static boolean isPalineDrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left ++ ;
            right -- ;
        }
        return true;
    }
}
