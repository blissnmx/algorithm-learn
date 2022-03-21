/**
 * @author ning_mx
 * @date 21:54 2022/3/20
 * @desc
 */
package 排序;

import java.util.Arrays;

/**
 * @author ning_mx
 * @date 2022/3/20
 * 计数排序，适合数组内的数据在一定范围k内，并且k远小于数组长度n
 */
public class 计数排序 {
    public static void countSort(int[] nums){
        int min = Integer.MAX_VALUE ;
        int max = Integer.MIN_VALUE ;
        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        int[] numCounts = new int[max - min + 1];
        for (int num : nums) {
            //数字固定顺序，用num当做下标，即可利用数组下标顺序特性，进行排序
            numCounts[num-min]++;
        }
        int j = 0 ;
        for (int i = min; i <=max ; i++) {
            int count = numCounts[i-min];
            while (count != 0) {
                nums[j] = i ;
                count --;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 5, 1, 4, 5, 6, 8, 9, 7, 6, 3, 2, 1, 6};
        countSort(nums);
        Arrays.stream(nums).forEach(System.out::print);
    }
}
