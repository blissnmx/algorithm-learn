/**
 * @author ning_mx
 * @date 10:59 2022/3/7
 * @desc
 */
package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ning_mx
 * @date 2022/3/7
 * 给定一组整数数组，求连续子数组之和为k的个数
 * 例如：数组[1,-2,1,-3,4,2,1]中连续子数组和为3的子数组有：[1,2]、[2,-3,4]、[-3,4,2]、[2,1]
 */
public class 整数数组中和等于k的子数组个数 {

    /**
     * 思路：连续非正整数数组求子数组之和，不能使用双指针求解；需要借助O(n)的空间求解
     * 可以使用连续子数组的和减去目标值k求解,哈希表中保存sum以及sum出现的次数
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public static int findSubArraySumKCount(int[] arr, int k) {
        int sum = 0, count = 0;
        Map<Integer, Integer> sums = new HashMap<>();
        sums.put(0, 1);
        for (int num : arr) {
            sum += num;
            if (sums.containsKey(sum - k)) {
                count += sums.get(sum - k);
            }
            sums.put(sum, sums.getOrDefault(sum - k, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, -2, 1, -3, 4, 2, 1};
        System.out.println(findSubArraySumKCount(arr, 3));
    }
}
