/**
 * @author ning_mx
 * @date 17:24 2022/3/7
 * @desc
 */

/**
 * @author ning_mx
 * @date 2022/3/7
 */
public class TestArrayLeftSumEqualRightSumIndex {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 3, 2, 6};
        int sum = 0 ;
        for (int num : nums) {
            sum+=num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(sum - nums[i] - leftSum == leftSum){
                System.out.println(i);
                return;
            }
            leftSum += nums[i];

        }
        System.out.println(-1);
    }
}
