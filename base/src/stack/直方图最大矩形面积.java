/**
 * @author ning_mx
 * @date 14:22 2022/3/3
 * @desc
 */
package stack;

import sun.nio.cs.ext.MacHebrew;

import java.util.Stack;

/**
 * 直方图是由排列在同一基线上的相邻柱子组成的图形。
 * 输入一个由非负数组成的数组，数组中的数字是直方图宽为1的柱子的高。
 * 求直方图中最大矩形的面积。例如，输入数组[3, 2, 5, 4, 6, 1, 4, 2]
 * 该直方图中最大的矩形的面积为12
 * @author ning_mx
 * @date 2022/3/3
 */
public class 直方图最大矩形面积 {

    /**
     * 解法一：暴力求解
     * 固定一个位置，求得与剩余直方图的每个面积，面积 = 最小的高度 * 宽度
     * 时间复杂度O(n^2)
     */
    public static int maxRectangleArea_one(int[] heights) {
        int maxArea = 0 ;
        for (int i = 0; i < heights.length; i++) {
            int min = heights[i];
            for (int j = i; j < heights.length; j++) {
                min = Math.min(min, heights[j]);
                maxArea = Math.max(maxArea, (j - i + 1) * min);
            }
        }
        return maxArea;
    }

    /**
     * 解法二：分治法
     * 观察直方图中的面积可知，面积依赖于最小高度，最大面积有三种：
     * 1、最小高度*总的宽度
     * 2、最小高度的左边
     * 3、最小高度的右边
     * 时间复杂度O(nlogn)
     */
    public static int maxRectangleArea_two(int[] heights){
        return maxArea(heights, 0, heights.length);
    }

    private static int maxArea(int[] heights, int start, int end) {
        if(start == end){//数组长度为0
            return 0;
        }
        if (start + 1 == end) {//数组长度为1
            return heights[start];
        }
        int minIdx = start;
        for (int i = start; i < end; i++) {
            if(heights[minIdx] > heights[i]){
                minIdx = i ;
            }
        }
        int maxArea =  (end - start ) * heights[minIdx] ;
        int leftArea = maxArea(heights, start, minIdx);
        int rightArea = maxArea(heights, minIdx + 1, end);
        maxArea = Math.max(maxArea, leftArea);
        maxArea = Math.max(maxArea, rightArea);
        return maxArea;
    }

    /**
     * 使用栈维护一个递增的序列，存放比当前高度低的下标
     * 若栈顶大于当前高度，则出栈，目的找到前后比当前高度低的两个坐标，得到当前高度的最大面积
     */
    public static int maxRectangleArea_three(int[] heights) {
        Stack<Integer> idxMinHStack = new Stack<>();
        idxMinHStack.push(-1);//哨兵，简化空栈处理逻辑
        int maxArea = 0 ;
        for (int i = 0; i < heights.length; i++) {
            while (idxMinHStack.peek() != -1 && heights[idxMinHStack.peek()] > heights[i]) {
                //弹出栈顶元素，求的栈顶元素的最大面积；
                // 即此时栈顶左边的低于栈顶，当前元素高度也低于栈顶
                int height = heights[idxMinHStack.pop()];
                int width = i - idxMinHStack.peek() - 1 ;
                maxArea = Math.max(maxArea,width * height);
            }
            idxMinHStack.push(i);
        }
        while (idxMinHStack.peek() != -1){
            Integer pop = idxMinHStack.pop();
            int width = heights.length - idxMinHStack.peek() - 1;
            int height = heights[pop];
            maxArea = Math.max(maxArea, width * height);
        }

        return maxArea ;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{3, 2, 5, 4, 6, 1, 4, 2};
        System.out.println(maxRectangleArea_one(heights));
        System.out.println(maxRectangleArea_two(heights));
        System.out.println(maxRectangleArea_three(heights));
    }
}
