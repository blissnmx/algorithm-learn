package array;

import java.util.HashMap;

/**
 * @author  blissnmx
 * @date    17:50 2022/2/16
 * @description
 *输入一个整数数组，如果一个数字左边的子数组数字之和等于右边的子数组数字之和，请返回该数字的下标。
 * 如果存在多个这样的数字，则返回最左边一个的下标。如果不存在这样的数字，则返回-1。
 * 例如在数组[1, 7, 3, 6, 2, 9]中，下标为3的数字（值为6）左边三个数字1、7、3和右边两个数字2和9的和相等，
 * 都是11，因此正确的输出值是3
 */
public class 左右两边子数组的和相等 {

    /**
     * 思考：
     *  数组之和问题，（右边和）数组之和sum-当前的数组之和 == （当前数组之和-当前值）（左边和）
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static int leftSumEqualsRighSum(int[] nums) {
        int result = -1;
        int sum = 0 ;
        for (int num : nums) {
            sum += num ;
        }
        int sumTmp = 0 ;
        for (int i = 0; i < nums.length; i++) {
            int leftSum = sumTmp ;
            sumTmp += nums[i];
            int rightSum = sum - sumTmp;
            if (leftSum == rightSum) {
                return i ;
            }
        }
        return  result;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 3, 6, 2, 9};
        System.out.println("leftSumEqualsRighSum(nums) = " + leftSumEqualsRighSum(nums));

    }
}
