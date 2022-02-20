/**
 * @author blissnmx
 * @date 15:10 2022/2/14
 * @desc
 */
package array;

/**
 * @author blissnmx
 * @date 2022/2/19
 * 输入一个二维矩阵，如何计算给定左上角坐标和右下角坐标的子矩阵数字之和？
 * 对同一个二维矩阵，计算子矩阵数字之和的函数可能输入不同的坐标而被反复调用多次。
 * 例如输入二维矩阵，以及左上角坐标为(2, 1)和右下角坐标为(4, 3)，该函数输出8。
 * 3 0 1 4 2
 * 5 6 3 2 1
 * 1 2 0 1 5
 * 4 1 0 1 7
 * 1 0 3 0 5
 */
public class 二维子矩阵的和 {
    /**
     * @param nums
     * @return
     * 思路： 计算数组之和，先计算每个坐标之前的数组之和，再减去重叠部分得到目标和
     * 使用nums.length+1 避免坐标为-1，每个sum[i+1][j+1]对应nums[i][j]==>sum正上方的数的sum+当前行的sum
     * 时间复杂度：O(N2) 循环总共执行了n*n次
     * 空间复杂度：O(n)
     */
    public static int subArraySubSum (int[][] nums ,int i1 ,int j1 ,int i2 ,int j2) {
        int result = 0 ;
        int[][] sums = new int[nums.length+1][nums[0].length+1];
        //计算所有点的和
        for (int i = 0; i < nums.length; i++) {
            int rowsum = 0 ;
            for (int j = 0; j < nums[i].length; j++) {
                rowsum += nums[i][j];
                sums[i+1][j+1] = rowsum + sums[i][j+1] ;
            }
        }
        System.out.println();
        result = sums[i2+1][j2+1] - sums[i1][j2+1] - sums[i2+1][j1] + sums[i1][j1];
        return result;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        System.out.println("subArraySubSum(nums,2,1,4,3) = " + subArraySubSum(nums, 2, 1, 4, 3));
    }
}
