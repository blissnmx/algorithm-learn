
package 排序;

import java.util.Arrays;

/**
 * @author ning_mx
 * @date 2022/3/21
 */
public class 归并排序 {
    //迭代
    public static int[] sortArrayFor(int[] nums) {
        int length = nums.length;
        int[] src = nums ;
        int[] dst = new int[length];
        for (int seg = 1; seg < length; seg++) {
            for (int start = 0; start < length; start += seg * 2) {
                int mid = Math.min(start + seg, length);
                int end = Math.min(start + seg * 2, length);
                int i = start , j = mid ,k = start ;
                while (i < mid || j < end) {
                    if (j == end || (i < mid && src[i] < src[j])) {
                        dst[k++] = src[i++];
                    }else{
                        dst[k++] = src[j++];
                    }
                }
            }
            int[] tmp = src ;
            src = dst ;
            dst = tmp ;
        }
        return src ;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,4,5,3,2};
        Arrays.stream(sortArrayFor(nums)).forEach(System.out::print);
    }
}
