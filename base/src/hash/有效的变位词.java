/**
 * @author ning_mx
 * @date 11:06 2022/3/1
 * @desc
 */
package hash;

/**
 * @author ning_mx
 * @date 2022/3/1
 * 给定两个字符串s和t，请判断它们是不是一组变位词。
 * 在一组变位词中，如果它们中的字符以及每个字符出现的次数都相同，但字符的顺序不能。
 * 例如"anagram"和"nagaram"就是一组变位词。
 */
public class 有效的变位词 {
    /**
     * 每个字符出现的次数相同，使用hash key存放字符， value出现次数
     * 因单词都是有26个英文字母组成，可使用26位的数组代替hash表
     */
    public static boolean isAnagram(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] charNums = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            charNums[word1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            if (charNums[word2.charAt(i) - 'a'] == 0) {
                return false;
            }
            charNums[word2.charAt(i) - 'a']--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("isAnagram(\"ata\", \"taa\") = " + isAnagram("ata", "taa"));
    }
}
