/**
 * @author ning_mx
 * @date 20:55 2022/3/20
 * @desc
 */
package 排序;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ning_mx
 * @date 2022/3/20
 * 快速排序
 */
public class 快速排序 {

    public static void quickSort(int[] nums, int start, int end) {
        if (end > start) {
            int t = partition(nums, start, end);
            quickSort(nums, start, t - 1);
            quickSort(nums, t + 1, end);
        }
    }

    public static int partition(int[] nums, int start, int end) {
        int target = new Random().nextInt(end - start + 1) + start;
        swap(nums, target, end);
        int left = start - 1, right = start;
        while (right < end) {
            if (nums[right] < nums[end]) {
                left++;
                //left right交换位置
                swap(nums, left, right);
            }
            right++;
        }
        //将目标值与left交换位置
        left++;
        swap(nums, left, end);
        return left;
    }

    public static void swap(int[] nums, int i, int j) {
        if (i != j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 5, 3, 6, 7, 8};
        quickSort(nums, 0, nums.length - 1);
        Arrays.stream(nums).forEach(System.out::print);
    }
}
