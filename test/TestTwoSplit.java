/**
 * @author ning_mx
 * @date 14:38 2022/3/29
 * @desc
 */

/**
 * @author ning_mx
 * @date 2022/3/29
 * 二分法求根号n
 */
public class TestTwoSplit {
    public static int twoSplit(int n ) {
       int left = 1 ;
       int right = n ;
        while (left < n) {
            int mid = (left + right) /2 ;
            if(mid ==  n / mid){
                return mid ;
            }
            if(mid > n / mid){
                right--;
            }
            if (mid < n / mid) {
                left++;
            }
        }
        return 0 ;
    }

    public static void main(String[] args) {
        System.out.println(twoSplit(9));
    }
}
