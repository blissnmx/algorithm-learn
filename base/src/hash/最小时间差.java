/**
 * @author ning_mx
 * @date 14:52 2022/3/1
 * @desc
 */
package hash;

import sun.nio.cs.ext.MacHebrew;

import java.util.Arrays;
import java.util.List;

/**
 * @author ning_mx
 * @date 2022/3/1
 * 给你一组范围在00:00至23:59的时间，求它们任意两个时间之间的最小时间差。
 * 例如，输入时间数组["23:50", "23:59", "00:00"]，"23:59"和"00:00"之间只有1分钟间隔，是最小的时间差。
 */
public class 最小时间差 {
    /**
     * 解法：因为数组中存放的是时间，可以转化为分钟，一天有24*60=1440
     * 用数组下标0~1440标识一天的每一分钟，若时间存在则值为true，判断相邻的两个true的时间差
     * --也可用hash存放分钟和是否出现过；若字符出现过则最小时间差为0,；
     * --求最小时间差需要判断第一个时间和最后一个时间的差值（第二天）
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     */
    public static int findTimeMinDiff(List<String> timeStrs) {
        if (timeStrs.size() > 1440) {
            //有重复时间
            return 0;
        }
        boolean[] minFlags = new boolean[1440];
        for (String timeStr : timeStrs) {
            int idxMinute = Integer.parseInt(timeStr.split(":")[0]) * 60 + Integer.parseInt(timeStr.split(":")[1]);
            if (minFlags[idxMinute]) {
                return 0;
            }
            minFlags[idxMinute] = true;
        }
        int pre = -1, min = 1440, first = 1440, last = 0;
        for (int i = 0; i < minFlags.length; ++i) {
            if (minFlags[i]) {
                if (pre >= 0) {
                    min = Math.min(min, (i - pre));
                } else {
                    first = i;
                }
                pre = i;
                last = Math.max(last, i);
            }
        }
        min = Math.min(min, (first + 1440 - last));
        return min;
    }

    public static void main(String[] args) {
        String[] times = new String[]{"23:50", "23:59", "00:00"};
        System.out.println("findTimeMinDiff(Arrays.asList(times)) = " + findTimeMinDiff(Arrays.asList(times)));
    }
}
