/**
 * @author ning_mx
 * @date 16:46 2022/3/11
 * @desc
 */

import java.net.Inet4Address;
import java.util.*;

/**
 * @author ning_mx
 * @date 2022/3/11
 * 例如输入字符串s1为"ab"，s2为"dgbaf"，由于s2中包含s1的变位词"ba"，因此输出是true。
 */
public class TestChangeWordIsExists {
    public static void main(String[] args) {
        String s2 = "agbaf";
        String s1 = "ab";
       /* char[] chs2 = s2.toCharArray();
        char[] chs1 = s1.toCharArray();
        Arrays.sort(chs2);
        Arrays.sort(chs1);
        String ss2 = new String(chs2);
        String ss1 = new String(chs1);
        System.out.println(chs1);
        System.out.println(chs2);
        int start = 0 ;
        for (int right = chs1.length; right< chs2.length; right++) {
            String sub = ss2.substring(start,right);
            if(sub.equals(ss1)){
                System.out.println("true");
                break;
            }
            start++;
        }
*/
        //因英文字符只有26个，所以map最大为26，可理解为常数
        /*Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
            map.put(s2.charAt(i), map.getOrDefault(s1.charAt(i), 0) - 1);
        }
        for (int right = s1.length(); right < s2.length(); right++) {
            char ch = s2.charAt(right);
            if (map.containsKey(ch)) {
                map.put(s2.charAt(right), map.get(ch) - 1);
            }else{
                map.put(s2.charAt(right - s2.length()),map.getOrDefault(s2.charAt(right-s2.length()),0)+1);
            }
            if(isAllZero(map.values())){
                System.out.println("true");
                break;
            }
        }*/
        int[] bits = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            bits[s1.charAt(i) - 'a']++;
            bits[s2.charAt(i) - 'a']--;
        }
        if (isArrayZero(bits)) {
            System.out.println(true);
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            bits[s2.charAt(i) - 'a']--;
            bits[s2.charAt(i - s1.length()) - 'a']++;
            if (isArrayZero(bits)) {
                System.out.println(true);
            }
        }
        System.out.println(false);
    }

    public static boolean isArrayZero(int[] arr) {
        for (int i : arr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllZero(Collection<Integer> sets) {
        return sets.stream().mapToLong(d -> d).sum() == 0;
    }


    /**
     * 输入两个字符串s1和s2，如何找出s2的所有变位词在s1中的起始下标？
     * 假设两个输入字符串中只包含英语小写字母。
     * 例如输入字符串s1为"cbadabacg"，s2为"abc"，s2有两个变位词"cba"和"bac"是s1中的字符串，输出它们在s1中的起始下标0和5。
     */
    public static List<Integer> findChangeWordIndex(String s1, String s2) {
        List<Integer> result = new ArrayList<>();
        int[] bits = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            bits[s2.charAt(i) - 'a']++;
            bits[s1.charAt(i) - 'a']--;
        }
        if (isArrayZero(bits)) {
            result.add(0);
        }
        for (int i = s2.length(); i < s1.length(); i++) {
            bits[s2.charAt(i) - 'a']--;
            bits[s2.charAt(i - s1.length() - 'a')]++;
            if (isArrayZero(bits)) {
                result.add(i - s1.length() + 1);
            }
        }

        return result;
    }
}
