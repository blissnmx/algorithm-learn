/**
 * @author ning_mx
 * @date 2021/12/19
 * 输入两个二进制的字符串，请计算他们的和，并以二进制字符串的形式输出。
 * 例如输入的二进制字符分别为“11”和“10”，则输出“101”。
 */
public class 二进制加法 {

    /**
     * @param a 二进制形式字符串
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        //将两个字符串位数对齐，左边补0
        if(a.length() > b.length()){
             int tem = a.length() - b.length();
             for(int i = 1 ;i<= tem ; ++i){
                 b = "0" + b ;
             }
        }else if(a.length() < b.length()){
            int tem = b.length() - a.length();
            for(int i = 1 ;i<= tem ; ++i){
                a = "0" + a ;
            }
        }
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        int carry = 0 ;
        int sum = 0 ;
        for(int i = a.length() -1 ; i>=0 ; --i){
            int va = Integer.parseInt(String.valueOf(a.charAt(i)));
            int vb = Integer.parseInt(String.valueOf(b.charAt(i)));
            sum = va + vb + carry ;
            if(sum >= 2 ){
                carry = 1 ;
                sum = 0 ;
            }
            result.append(sum);
            if(i == 0 && carry != 0){
                result.append(carry);
            }
        }
        return result.reverse().toString() ;
    }

    public static void main(String[] args) {
        System.out.println("addBinary  = " + addBinary("11111111", "101"));
    }
}
