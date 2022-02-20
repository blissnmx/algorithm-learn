package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author  blissnmx
 * @date    17:50 2022/2/16
 * @description
 *输入一个只包含0和1的数组，请问如何求最长0和1的个数相同的连续子数组的长度？
 * 例如在数组[0, 1, 0]中有两个子数组包含相同个数的0和1，分别是[0, 1]和[1, 0]，它们的长度都是2，因此输出2。
 */
public class 零和1个数相同的子数组 {

    /**
     * 思考：
     * 子数组只包含0和1，个数相同，则用-1替换0后，子数组的和为0
     * 即求解子数组和为0的最长子数组的长度,计算每个位置的和sum，存入map，当某个sum值已存在说明下标之间的和为0
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static int maxLenSubSumZero(int[] nums) {
        HashMap<Integer,Integer> sumToIndex = new HashMap();
        int maxLen = 0,sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 0 ?-1 : 1);
            if(sumToIndex.containsKey(sum)){//sum出现过，则说明下标之间的数字之和为0，sum-0=sum
                maxLen = Math.max(maxLen, i - sumToIndex.get(sum) );
            }else{
                sumToIndex.put(sum, i);
            }
        }
        return  maxLen;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 0, 1, 0,1};
        System.out.println("maxLenSubSumZero(nums) = " + maxLenSubSumZero(nums));
    }
}
