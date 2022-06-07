package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author blissnmx
 * @date 12:50 2022/2/11
 * @description 输入一个递增排序的数组和一个值k，请问如何在数组中找出两个和为k的数字并返回它们的下标？
 * 假设数组中存在且只存在一对符合条件的数字，同时一个数字不能使用两次。
 * 例如输入数组[1, 2, 4, 6, 10]，k的值为8，数组中的数字2和6的和为8，它们的下标分别为1和3。
 */
public class 排序数组中两个数字之和 {

    /**
     * 思考：
     * 方法一 :暴力求解，两层循环以此比较数组中的每个数字与其他数字之和是否等于k
     * 方法二：使用哈希表key保存k-i的值a，value保存i的下标，循环数组找到a
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static int[] arrayTwoSum_双指针(int[] nums, int k) {
        int[] result = new int[2];
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i] + nums[j];
            if (temp == k) {
                return new int[]{i, j};
            } else if (temp > k) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public static int[] arrayTwoSum_哈希表(int[] nums, int k) {
        int[] result = new int[2];
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hash.put(k - nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (hash.get(nums[i]) != null) {
                Integer j = hash.get(nums[i]);
                return new int[]{i, j};
            }
        }
        return result;
    }

    /**
     * 排序数组求和，反向双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static int[] arrayTwoSumDoublePoint(int[] nums, int k) {
        int[] result = new int[2];
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > k) {
                right--;
            } else if (sum < k) {
                left++;
            } else {
                return new int[]{left, right};
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 6, 10};
//        System.out.println("arrayTwoSum_双指针(nums, 7) = " );
//        Arrays.stream(arrayTwoSum_双指针(nums, 7)).forEach(System.out::println);
//        System.out.println("arrayTwoSum_哈希表(nums,7) = "  );
//        Arrays.stream(arrayTwoSum_哈希表(nums, 7)).forEach(System.out::println);
        Arrays.stream(arrayTwoSumDoublePoint(nums, 8)).forEach(System.out::println);

    }
}
