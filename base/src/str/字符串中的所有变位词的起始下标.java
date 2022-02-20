package str;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  blissnmx
 * @date    17:50 2022/2/20
 * @description
 *输入两个字符串s1和s2，如何判断s2中是否包含s1的某个变位词？
 * 如果s2中包含s1的某个变位词，则s1至少有一个变位词是s2的子字符串。
 * 假设两个输入字符串中只包含英语小写字母。
 * 例如输入字符串s1为"ab"，s2为"dgbaf"，由于s2中包含s1的变位词"ba"，因此输出是true。
 * 如果输入字符串s1为"ac"，s2为"dcgaf"，输出为false。
 */
public class 字符串中的所有变位词的起始下标 {

    /**
     * 思考：
     * 用长度为26的数组存储字符串s1中每个单词出现的次数，循环s2，双指针移动，右边的数对应位置减1，左边删除的加1
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static List<Integer> changeWordIsExists(String s1, String s2) {
        List<Integer> result = new ArrayList<>();
        if(s1.length()>s2.length()){
            return result;
        }
        int[] bitSums = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            bitSums[s1.charAt(i) - 'a'] ++;
            bitSums[s2.charAt(i) - 'a'] -- ;
        }
        if (checkArraySumZero(bitSums)) {
            result.add(0);
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            bitSums[s2.charAt(i) - 'a'] --;
            bitSums[s2.charAt(i- s1.length()) - 'a'] ++;
            if (checkArraySumZero(bitSums)) {
                result.add(i-s1.length()+1);
            }
        }
        return result ;
    }

    private static boolean checkArraySumZero(int[] nums){
        for (int num : nums) {
            if (num != 0) {
                return  false ;
            }
        }
        return true ;
    }

    public static void main(String[] args) {
         System.out.println("changeWordIsExists = " + changeWordIsExists("fa", "dgbaf"));
    }
}
