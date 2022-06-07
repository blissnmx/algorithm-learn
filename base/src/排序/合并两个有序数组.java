/**
 * @author ning_mx
 * @date 10:24 2022/3/21
 * @desc
 */
package 排序;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author ning_mx
 * @date 2022/3/21
 * 给定两个有序数组nums1[1,3,5] 和nums2[2,4,6],输入合并后的排序数组
 */
public class 合并两个有序数组 {
    public static int[] mergeSortArray(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length || j < nums2.length) {
            if ((i < nums1.length && nums1[i] < nums2[j]) || j == nums2.length) {
                result[k] = nums1[i];
                i++;
            } else {
                result[k] = nums2[j];
                j++;
            }
            k++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3, 5};
        int[] nums2 = new int[]{2, 4, 6};
        int[] ints = mergeSortArray(nums1, nums2);
        Arrays.stream(ints).forEach(System.out::print);
    }
}
