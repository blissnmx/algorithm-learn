/**
 * @author ning_mx
 * @date 16:56 2022/3/7
 * @desc
 */

/**
 * @author ning_mx
 * @date 2022/3/7
 */
public class TestArrSumLessKMinSubLenth {
    public static void main(String[] args) {
        //子数组之和大于等于k的最短数组长度
        int[] nums = new int[]{1, 4, 7, 5, 5, 1};
        int k = 6;
        int left = 0, sum = 0, min = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= k && left <= right) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}
