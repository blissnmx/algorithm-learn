package str;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author  blissnmx
 * @date    17:28 2022/2/20
 * @description
 *输入两个字符串s和t，请找出s中包含t的所有字符的最短子字符串。
 * 例如输入s为字符串"ADDBANCAD"，t为字符串"ABC"，则s中包含字符'A'、'B'、'C'的最短子字符串是"BANC"。
 * 如果不存在符合条件的子字符串，返回空字符串""。如果存在多个符合条件的子字符串，返回任意一个。
 */
public class 含有所有字符的最短字符串 {

    /**
     * 时间复杂度：O(n+n*m) ==> O(n*m)
     * 空间复杂度：O(1)
     */
    public static String containerAllWordMinLength(String words,String target) {
        AtomicInteger ac = new AtomicInteger();

        int start =0 ,end = target.length()-1,minIdx = 0,maxIdx = words.length(),minLen = Integer.MAX_VALUE;

        while (end < words.length()) {
            if(checkIsAllContains(words.substring(start,end+1),target,ac)){
                if( (end - start +1)<minLen){
                    minIdx = start;
                    maxIdx = end ;
                    minLen = maxIdx - minIdx +1 ;
                }
                start ++ ;
            }else{
                end ++ ;
            }
            ac.incrementAndGet();
        }
        System.out.println(ac.get());
        return  maxIdx-minIdx > words.length()?"":words.substring(minIdx,maxIdx+1);
    }

    private static boolean checkIsAllContains(String str, String target,AtomicInteger ac ) {
        for (char c : target.toCharArray()) {
            if(str.indexOf(c)== -1){
                return false;
            }
            ac.incrementAndGet();
        }
        return true;
    }
    /*
    * 优化方案
    * count记录
    */
    public static String containerAllWordMinLength2(String words,String target) {
        AtomicInteger ac = new AtomicInteger();

        int start =0 ,end = 0,minIdx = 0,maxIdx = words.length(),minLen = Integer.MAX_VALUE,count = target.length();
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (char c : target.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        while (end < words.length()) {
            if(count <= 0){
                if( (end - start) < minLen){
                    minIdx = start;
                    maxIdx = end ;
                    minLen = maxIdx - minIdx ;
                }
                if(charMap.containsKey(words.charAt(start))){
                    charMap.put(words.charAt(start),charMap.get(words.charAt(start))+1);
                    if (charMap.get(words.charAt(start)) == 1) {
                        count++;
                    }
                }
             start ++ ;
            }else{
                if(charMap.containsKey(words.charAt(end))) {
                    charMap.put(words.charAt(end), charMap.get(words.charAt(end)) - 1);
                    if (charMap.get(words.charAt(end)) == 0) {
                        count -- ;
                    }
                }
                end ++ ;
            }
            ac.incrementAndGet();
        }
        System.out.println(ac.get());
        return  maxIdx-minIdx > words.length() ? "": words.substring(minIdx,maxIdx);
    }

    public static void main(String[] args) {
        System.out.println("noRepeatWordMaxLength(\"ACEBFCABD\", \"ABC\") = " + containerAllWordMinLength("ACEBFCABD", "ABC"));

        System.out.println("noRepeatWordMaxLength2(\"ACEBFCABD\", \"ABC\") = " + containerAllWordMinLength2("ACEBFCABD", "ABC"));
    }
}
