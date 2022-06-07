/**
 * @author ning_mx
 * @date 10:15 2022/3/29
 * @desc
 */

import java.util.Arrays;
import java.util.Random;


/**
 * @author ning_mx
 * @date 2022/3/29
 * 快速排序
 */
public class TestQuickSort {
    public static void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = partion(nums, start, end);
            quickSort(nums, start, mid - 1);
            quickSort(nums, mid + 1, end);
        }
    }

    private static int partion(int[] nums, int start, int end) {
        int mid = new Random().nextInt(end - start + 1) + start;
        //将mid和end交换位置
        swap(nums, mid, end);
        int p1 = start - 1, p2 = start;
        while (p2 < end) {
            if (nums[p2] < nums[end]) {
                p1++;
                swap(nums, p1, p2);
            }
            p2++;
        }
        p1++;
        swap(nums, p1, end);
        return p1;
    }

    private static void swap(int[] nums, int mid, int end) {
        if (mid != end) {
            int tmp = nums[mid];
            nums[mid] = nums[end];
            nums[end] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 5, 3, 4};
        quickSort(nums, 0, nums.length - 1);
        Arrays.stream(nums).forEach(System.out::print);
    }
}
