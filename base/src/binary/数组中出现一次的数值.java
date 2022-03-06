package binary;
/**
 * @author blissnmx
 * @date 2022/2/9
 * 给定一个整数数组，数组中只有一个数字出现了一次，其他数字出现了3次，求出现一次的数组；
 * eg 输入： [1,2,1,2,1,2,3] 输出 3
 */
public class 数组中出现一次的数值 {

    /**
     * @author  blissnmx
     * @date    17:21 2022/2/10
     * @description 将每个数字转化为二进制，对每个数字的每个数位相加，如果出现三次的数位之和%3，
     * 若为0，则说明出现一次的数当前的数位是0，若为1，则出现一次的数位为1，可以通过&1运算得到结果的二进制数，转化为十进制即可
     */
    public static int findOnceNum(int[] nums){
        int[] bitSums = new int[32];
        for (int num : nums) {
            //num数字右移31位，和1做&运算得到最左边的数位
            for(int i =0 ;i<32 ; ++i){
                bitSums[i] += num >> (31-i) & 1 ;
            }
        }
        int result = 0;
        //解法一：根据二进制形式求整数，从左往右 结果从0开始，每次左移一位+当前数位的值（0或1）
/*        for (int i = 0; i < 32; i++) {
            result = (result << 1) + bitSums[i] % 3;
        }*/
        //解法二：从右往左，数位的值*（2<<（0到31） 做累加和
        for (int i = 0; i < 32; i++) {
            int bit = bitSums[i] % 3;
            result = result + bit * (1 << (31-i));
        }
        return result;
    }

    // 使用二进制求解，问题转化为
    // 1、求一个整n数的二进制第k数位是0还是1 2、求一个二进制数的十进制
    public static int binaryPositionIsOneOrZero(int n,int k ) {
        int result = 0 ;
        for (int i = 0; i < 32; ++i) {
             result = n >> (31 - i) & 1 ;
        }
        return result;
    }

    public static void main(String[] args) {
        //System.out.println("findOnceNum  = " + findOnceNum(new int[]{1, 1, 1, 2, 2, 2, 3,3,3,100}));
        System.out.println("binaryStrToInt(\"110\") = " + binaryStrToInt("110"));
    }

    /**
     * 已知二进制数字符串101101，求十进制整数
     */
    public static int binaryStrToInt(String bstr) {
        int result = 0 ;
        /*for (int i = 0; i < bstr.length(); i++) {
            int bit = Integer.parseInt(String.valueOf(bstr.charAt(i)));
            result = (result << 1) + bit;
        }*/
        for (int i = 0; i < bstr.length(); i++) {
            int bit = Integer.parseInt(String.valueOf(bstr.charAt(i)));
            result += bit * (1<< (31-(31 - bstr.length()) - 1 -i)) ;
        }

        return  result ;
    }
}
