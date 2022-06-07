/**
 * @author ning_mx
 * @date 16:01 2022/3/4
 * @desc
 */
package stack;

import sun.security.krb5.internal.crypto.HmacSha1Aes128CksumType;

import java.util.Stack;

/**
 * @author ning_mx
 * @date 2022/3/4
 * 请在一个由0、1组成的矩阵中找出最大的只包含1的矩形并输出它的面积。
 * 例如在以下的矩阵中，最大的只包含1的矩阵部分所示，它的面积是6。
 * 1 0 1 0 0
 * 0 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 */
public class 矩阵中最大的矩形 {

    /**
     * 求都为1的矩阵的面积，可以将问题转化为求直方图中最大阴影面积
     * 矩阵中的每一行和上一行的值组成直方图的高，可知第三行的直方图中组成了最大的阴影面积
     */
    public static int maxArea(int[][] nums) {
        int maxArea = 0;
        if (nums.length == 0 || nums[0].length == 0) {
            return 0;
        }
        int[] heights = new int[nums[0].length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (nums[i][j] != 0) {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, calcRectangleMaxArea(heights));
        }
        return maxArea;
    }

    /**
     * 单调栈求直方图中最大矩形面积
     * 直方图的宽为1，高度依次为eg:[1,1,3,2,2]
     *
     * @param heights
     * @return
     */
    private static int calcRectangleMaxArea(int[] heights) {
        int maxArea = 0;
        //存储直方图的下标，找到每个直方图左右两边比自己低的直方图即可得到最大面积的宽度
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            //说明当前高度低于栈顶高度，需要找到左边低于栈顶高度的下标
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, width * height);
            }
            stack.push(i);
        }
        //此时处于栈中的下标，右边都是比它高的柱状图，左边是较低的
        while (stack.peek() != -1) {
            int height = heights[stack.pop()];
            int width = heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 0, 1, 0, 0}, {0, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}};
        System.out.println(maxArea(nums));
    }
}
