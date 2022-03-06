/**
 * @author ning_mx
 * @date 11:06 2022/3/1
 * @desc
 */
package hash;

import java.util.*;

/**
 * @author ning_mx
 * @date 2022/3/1
 *给定一组单词，请将它们按照变位词分组。
 * 例如输入一组单词["eat", "tea", "tan", "ate", "nat", "bat"]，
 * 则可以分成三组，分别是["eat", "tea", "ate"]、["tan", "nat"]和["bat"]。
 * 假设单词中只包含小写的英文字母。
 */
public class 变位词组 {
    /**
     * 解法一：英文字符的每个单词对应一个质数（2、3、5、7、、、101）,则每个单词字符的乘积是固定的，两个单词乘积相同，则说明是一组变词
     *       单词长度过长，可能出现int、long溢出
     * 时间复杂度O(mn)
     * 空间复杂度O(n)
     */
    public static List<List<String>> findAnagramGroup_1(String[] words) {
        int hash[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
                43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        Map<Integer, List<String>> result = new HashMap<>();
        for (String word : words) {
            int mutiple = 1 ;
            for (int i = 0; i < word.length(); i++) {
                mutiple *= hash[word.charAt(i) - 'a'];
            }
            result.putIfAbsent(mutiple, new ArrayList<>());
            result.get(mutiple).add(word);
        }
        return new ArrayList<>(result.values());
    }
    /**
     * 解法二：两个变位词排序后的单词相同
     * 时间复杂度O(nlogn)
     * 空间复杂度O(n)
     */
    public static List<List<String>> findAnagramGroup_2(String[] words) {
        Map<String, List<String>> result = new HashMap<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortStr = new String(chars);
            result.putIfAbsent(sortStr, new ArrayList<>());
            result.get(sortStr).add(word);
        }
        return new ArrayList<>(result.values());
    }

    public static void main(String[] args) {
        String[] words = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"} ;
        findAnagramGroup_1(words).stream().forEach(System.out::println);
        findAnagramGroup_2(words).stream().forEach(System.out::println);
    }
}
