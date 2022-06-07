package binary;

import java.util.Arrays;

/**
 * @author blissnmx
 * @date 12:50 2022/2/8
 * @description 对于正整数n，计算0到n之间每个数的二进制形式中1的个数，输出数组
 */
public class 二进制中1的个数 {

    /**
     * @param n
     * @return 解法一：使用(i&(i-1))抹掉i的最后的一位1,直到i=0为止，统计计算的次数
     * O(nk),k为二进制1的个数的最大值
     */
    public static int[] binaryCount1Num_1(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            int j = i;
            while (j != 0) {
                result[i]++;
                j = j & (j - 1);
            }
        }
        return result;
    }

    /**
     * @param n
     * @return 解法二：根据规--i的二进制形式中1的个数始终比(i&(i-1))的二进制形式中1的个数多1个
     * O(n)
     */
    public static int[] binaryCount1Num_2(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }

    /**
     * @param n
     * @return 解法三：对于正整数n，使用n/2计算，整数n=n/2左移1位的值，而左移1位后二进制中1的个数不变，即偶数n和n/2中1的个数相同
     * 对于奇数n，相当于n/2左移一位后最后一位加1得到，即1的个数比n/2多一个
     */
    public static int[] binaryCount1Num_3(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            //result[i] = result[i/2] + i%2 ;
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Arrays.stream(binaryCount1Num_1(3)).forEach(d -> System.out.print(d));
        System.out.println();
        Arrays.stream(binaryCount1Num_2(5)).forEach(d -> System.out.print(d));
        System.out.println();
        Arrays.stream(binaryCount1Num_3(8)).forEach(d -> System.out.print(d));

    }
}
