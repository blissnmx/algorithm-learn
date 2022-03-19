/**
 * @author blissnmx
 * @date 15:10 2022/2/14
 * @desc
 */
package array;

/**
 * @author blissnmx
 * @date 2022/2/14
 * 输入一个由正整数组成的数组和一个正整数k，请问数组中有多少个数字乘积小于k的连续子数组？
 * 例如输入数组[10, 5, 2, 6]，k的值为100，有8个子数组的所有数字的乘积小于100，
 * 它们分别是[10]、[5]、[2]、[6]、[10, 5]、[5, 2]、[2, 6]和[5, 2, 6]。
 */
public class 乘积小于k的子数组 {

    /**
     * @param nums
     * @return
     * 关键词：正整数、最小长度
     * 正向双指针,右指针增大数值，左指针减小数值
     * 时间复杂度：O(N) 循环总共执行了n次
     * 空间复杂度：O(1)
     */
    public static int subArrayProductTimes (int[] nums ,int k) {
        int count = 0,product = 1 ,l = 0 ;
        for (int r = 0; r < nums.length; r++) {
            product *= nums[r];
            while (l <= r && product > k) {
                product /= nums[l];
                l++;
            }
            count += ((r>l) ? (r-l+1) : 0);
        }
        return count ;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 5, 2, 6};
        System.out.println("subArrayProductTimes() = " + subArrayProductTimes(nums, 100));
        int l = 0 ,r = 0 ,product = nums[r],k = 100;
        int count = 0 ;
        while(l <= r && r< nums.length){
            if(product < k){
                count += r-l + 1 ;
                r++;
                if(r<nums.length){
                    product *= nums[r];
                }
            }else{
                product /= nums[l];
                l++;
            }
        }
        System.out.println(count);
    }
}
