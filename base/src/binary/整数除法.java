package binary; /**
 * @author blissnmx
 * @date 20:32 2021/12/19
 * @desc
 */

/**
 * @author blissnmx
 * @date 2021/12/19
 * 输入两个int型整数，求他们除法的商，要求不得使用乘号'*'、除号'/'以及
 * 求余符号'%'。当发生溢出时返回最大的整数值。假设除数不为0。例如，输入
 * 15/2,输出15/2的结果，即7。
 */

public class 整数除法 {
    /**
     * 暴力求解，直接使用减法计算
     * 时间复杂度：O(n)
     * 空间复杂度：n
     */
    public static int violenceDivide(int dividend , int divisor){
        int diff = dividend - divisor ;
        int result = 1 ;
        while (diff >= divisor) {
            diff -= divisor ;
            result ++ ;
        }
        return result;
    }

    /**
     * 优化减法，每次减去除数的倍数
     * 时间复杂度：O(logn)
     * 空间复杂度：n
     */
    public static int optimizeDivide(int dividend, int divisor) {
        int result = 1;
        int diff = dividend - divisor ;
        while (diff >= divisor) {
            if (diff >= (divisor + divisor)) {
                while(diff >= divisor + divisor){
                    result += 2 ;
                    diff -= (divisor + divisor);
                }
            }else{
                result ++ ;
                diff -= divisor ;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(violenceDivide(15, 2));
        System.out.println(optimizeDivide(15, 2));
    }
}
