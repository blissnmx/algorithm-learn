/**
 * @author ning_mx
 * @date 14:52 2022/3/1
 * @desc
 */
package hash;

/**
 * @author ning_mx
 * @date 2022/3/1
 * 有一门外星语言，它的字母表刚好包含所有的英文小写字母，只是字母表的顺序不同。
 * 给定一组单词和字母表顺序，请判断这些单词是否按照字母表的顺序排序。
 * 例如，输入一组单词["offer", "is", "coming"]，以及字母表顺序"zyxwvutsrqponmlkjihgfedcba"，
 * 由于字母'o'在字母表中位于'i'的前面，所以单词"offer"排在"is"的前面；同样由于字母'i'在字母表中位于'c'的前面，
 * 所以单词"is"排在"coming"的前面。因此这一组单词是按照字母表顺序排序的，应该输出true。
 */
public class 外星语言是否排序 {
    /**
     * 解法：字母表的顺序可使用数组0-25标识，即大小为26的数组，0标识z，以此类推25标识a；
     * 字符下标对应的组值越小优先级越高
     * 时间复杂度O(nm) m为字符串的平均长度
     * 空间复杂度O(1)
     */
    public static boolean isAlienSort(String[] words, String sortWord) {
        int[] sortFlag = new int[26];
        for (int i = 0; i < sortWord.length(); i++) {
            sortFlag[sortWord.charAt(i) - 'a'] = i + 1;
        }
        for (int i = 0; i < words.length - 1; i++) {
            //相邻两个元素的字符比较大小
            String word1 = words[i];
            String word2 = words[i + 1];
            int j = 0;
            while (j < word1.length() && j < word2.length()) {
                int i1 = sortFlag[word1.charAt(j) - 'a'];
                int i2 = sortFlag[word2.charAt(j) - 'a'];
                if (i1 > i2) {
                    return false;
                }
                if (i1 < i2) {
                    break;
                }
                j++;
            }
            if (word1.length() > word2.length() && j == word2.length()) {
                //字符相同，则短的单词应该在前面
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"off", "offer", "is", "coming"};
        String sort = "zyxwvutsrqponmlkjihgfedcba";
        System.out.println("isAlienSort(words) = " + isAlienSort(words, sort));
    }
}
