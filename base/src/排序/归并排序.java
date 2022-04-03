
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

    /**
     * 递归
     * 整体-->局部
     * 局部-->整体
     * @param nums 原数据
     * @param dst 排序后的数组
     * @param start  子数组的开始下标
     * @param end 子数组的长度，最后下标 = end - 1
     *
     */
    public static void mergeSort(int[] nums, int[] dst, int start, int end) {
        if (start + 1 >= end) {
            return ;
        }
        int mid = (start + end ) / 2 ;
        mergeSort(dst, nums,start ,mid);
        mergeSort(dst, nums,mid, end);
        //合并两个有序数据
        int i = start ,j = mid ,k = start ;
        while (i < mid || j < end) {
            if(j == nums.length  || (i<mid && (nums[i]<nums[j]))){
                dst[k] = nums[i] ;
                ++k ;++i;
            }else{
                dst[k] = nums[j];
                ++k ; ++j ;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,4,5,3,2};
        int[] dst = Arrays.copyOf(nums,nums.length);
        //Arrays.stream(sortArrayFor(nums)).forEach(System.out::print);
        mergeSort(nums,dst,0,nums.length) ;
        Arrays.stream(dst).forEach(System.out::print);
    }
}
