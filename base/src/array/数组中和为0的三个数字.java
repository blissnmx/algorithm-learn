package array;

import java.util.*;

/**
 * @author  blissnmx
 * @date    17:50 2022/2/11
 * @description
 *输入一个数组，如何找出数组中所有和为0的三个数字的三元组？
 * 注意返回值中不得包含重复的三元组。
 * 例如在数组中[-1, 0, 1, 2, -1, -4]中有两个三元组的和为0，它们分别是[-1, 0, 1]和[-1, -1, 2]。
 */
public class 数组中和为0的三个数字 {

    /**
     * 思考：
     * 因题中为提及数组是否排序，要使用双指针需要多数组先排序
     * 固定一个数字，问题转化为两数之和解法
     * 三元组不重复：在三个值和为0时，判断下一个值和当前的值是否一样，一样则说明重复了需要跳过
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    public static List<int[]> arrayThreeSum_双指针(int[] nums) {
        List<int[]>  result = new ArrayList<>();
        //数组排序后使用双指针求解
        Arrays.sort(nums);
        int k = 0;
        while (k<nums.length-2){
            towSum(nums,k,result);
            //解决返回值中不得包含重复的三元组。
            int temp = nums[k];
            while(k<nums.length && temp == nums[k]){
                ++k;
            }
        }
        return  result;
    }
    /**
     * @author  blissnmx
     * @date    17:54 2022/2/11
     * @param k 下标
     */
    public static void towSum(int[] nums , int k ,List<int[]> result){
        int i = k+1 ,j = nums.length - 1 ;
        while (i < j) {
            int temp = nums[k] + nums[i] + nums[j];
            if(temp > 0){
                j--;
            }else if(temp < 0){
                i++;
            }else{
                result.add(new int[]{nums[k], nums[i], nums[j]});
                //当前的k和j是固定的
                int tmp = nums[i];
                while (i < j && tmp == nums[i]) {
                    ++i ;
                }
            }
        }
    }



    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        arrayThreeSum_双指针(nums).stream().forEach(d->{
            System.out.println("---------------");
            Arrays.stream(d).forEach(System.out::println);
        });
    }
}
