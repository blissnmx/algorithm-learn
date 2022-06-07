/**
 * @author blissnmx
 * @date 15:10 2022/2/14
 * @desc
 */
package array;

/**
 * @author blissnmx
 * @date 2022/2/14
 * 输入一个正整数组成的数组和一个正整数k，请问数组中和大于或等于k的连续子数组的最短长度是多少？
 * 如果不存在所有数字之和大于k的子数组，则返回0。
 * 例如输入数组[5, 1, 4, 3]，k的值为7，和大于或等于7的最短连续子数组是[4, 3]，因此输出它的长度2。
 */
public class 和大于等于k的最短子数组 {

    /**
     * @param nums
     * @return 关键词：正整数、最小长度
     * 正向双指针
     * 时间复杂度：O(N) 循环总共执行了n次
     * 空间复杂度：O(1)
     */
    public static int minSubArrayLength(int[] nums, int k) {
        int minLen = nums.length, sum = 0, i = 0, j = 0;
        while (j < nums.length) {
            sum = sum + nums[j];
            while (i <= j && sum >= k) {
                minLen = Math.min(minLen, (j - i) + 1);
                sum = sum - nums[i];
                i++;
            }
            j++;
        }
        return minLen;
    }

    //举一反三  求和小于等于k的连续数组的个数 时间复杂度O(n)
    public static int countSubArray(int[] nums, int k) {
        int count = 0, sum = 0, l = 0;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (l <= r && sum > k) {
                sum -= nums[l];
                l++;
            }
            count += (r >= l) ? r - l + 1 : 0;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 3, 5, 7};
        System.out.println("maxSubArrayLength(nums, 7) = " + minSubArrayLength(nums, 7));

        System.out.println("countSubArray(nums,7) = " + countSubArray(nums, 7));

    }
}
