/**
 * @author ning_mx
 * @date 19:09 2022/3/7
 * @desc
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ning_mx
 * @date 2022/3/7
 * 输入一个数组，如何找出数组中所有和为0的三个数字的三元组？
 *  * 注意返回值中不得包含重复的三元组。
 *  * 例如在数组中[-1, 0, 1, 2, -1, -4]中有两个三元组的和为0，它们分别是[-1, 0, 1]和[-1, -1, 2]。
 */
public class TestArrSubSumZeroSubArr {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        //排序后用双指针求解
        Arrays.sort(nums);
        List<int[]> result = new ArrayList<>();

         for (int i= 0 ; i<nums.length -2 ;i++) {
             int existsNum = nums[i];
             twoSum(nums,i,result);
             //跳过相同的数字
             while(i<nums.length && existsNum == nums[i]){
                 i++;
             }
        }
    }

    private static void twoSum(int[] nums, int start, List<int[]> result) {
        int sum = 0 - nums[start];
        int left = start+1 ;
        int right = nums.length-1;
        while (left < right) {
            int sumTmp = nums[left] + nums[right];
            if(sumTmp > sum){
                right -- ;
            }else if(sumTmp<sum){
                left ++ ;
            }else{
                int[] ints = new int[]{nums[start], nums[left], nums[right]};
                result.add(ints);
                int tmp =  nums[left];
                while(left<right && nums[left] == tmp){
                    left ++ ;
                }
            }
        }
    }

}
