/**
 * @author ning_mx
 * @date 17:43 2022/3/2
 * @desc
 */
package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 输入一个数组，它的每个数字是某天的温度。请计算在每一天需要等几天才会有更高的温度。
 * 例如，如果输入数组[35, 31, 33, 36, 34]，那么输出为[3, 1, 1, 0, 0]。
 * 由于第一天的温度是35，要等3天才会有更高的温度36，因此对应的输出为3。第四天的温度是36，后面没有更高的温度，它对应的输出是0。
 *
 * @author ning_mx
 * @date 2022/3/2
 */
public class 每日温度 {
    /**
     * 用一个栈存储每个温度的下标，遇到大于栈顶的元素时，递归栈中元素，并计算下标差值就位所求天数，计算过差值的出栈
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public static int[] daliyTemperature(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0 ;i<nums.length;++i) {
            int num = nums[i];
            if(stack.empty()){
                stack.push(i);
            }else{
                int topVal = nums[stack.peek()];
                while(!stack.empty() && num > topVal) {
                    Integer pop = stack.pop();
                    result[pop] = i - pop ;
                    if(!stack.empty()){
                        topVal = nums[stack.peek()];
                    }
                }
                stack.push(i);
            }
        }
        return result ;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{35, 31, 33, 36, 34};
        int[] ns = daliyTemperature(nums);
        Arrays.stream(ns).forEach(System.out::println);
    }
}
