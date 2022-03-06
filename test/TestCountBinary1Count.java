/**
 * @author ning_mx
 * @date 10:36 2022/3/2
 * @desc
 */

/**
 * @author ning_mx
 * @date 2022/3/2
 *  0~n中二进制1的个数
 */
public class TestCountBinary1Count {

    public static int[] countBinaryOne(int n ){
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int j = i ;
            int count = 0 ;
            while(j != 0){
                j = j & (j - 1);
                count ++ ;
            }
            result[i] = count ;
        }
        return result ;
    }
    public static int[] countBinaryTwo(int n ){
        int[] result = new int[n];
        for (int i = 1; i < n; i++) {
           result[i] = result[i & (i-1)] + 1 ;
        }
        return result ;
    }

    public static int[] countBinaryThree(int n ){
        int[] result = new int[n];
        for (int i = 1; i < n; i++) {
            result[i] = result[i/2] + i % 2 ;
            //result[i] = result[i >> 1] + (i & 1);
        }
        return result ;
    }
}
