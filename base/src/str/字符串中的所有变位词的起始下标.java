package str;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  blissnmx
 * @date    17:50 2022/2/20
 * @description
 *输入两个字符串s1和s2，如何找出s2的所有变位词在s1中的起始下标？
 * 假设两个输入字符串中只包含英语小写字母。
 * 例如输入字符串s1为"cbadabacg"，s2为"abc"，s2有两个变位词"cba"和"bac"是s1中的字符串，输出它们在s1中的起始下标0和5。
 */
public class 字符串中的所有变位词的起始下标 {

    /**
     * 思考：
     * 用长度为26的数组存储字符串s1中每个单词出现的次数，循环s2，同向双指针移动，右边的数对应位置减1，左边删除的加1
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static List<Integer> changeWordAllIndex(String s1, String s2) {
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
         System.out.println("changeWordIsExists = " + changeWordAllIndex("fa", "dgbaf"));
    }
}
