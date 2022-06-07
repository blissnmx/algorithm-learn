package binary;

/**
 * @author blissnmx
 * @date 2021/12/19
 * 输入两个二进制的字符串，请计算他们的和，并以二进制字符串的形式输出。
 * 例如输入的二进制字符分别为“11”和“10”，则输出“101”。
 */
public class 二进制加法 {

    /**
     * 将两个二进制位数补齐，从右往左以此计算，结果字符串翻转得到结果
     */
    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        //对齐补0
        int diff = Math.abs(a.length() - b.length());
        StringBuilder sub = new StringBuilder();
        for (int i = 0; i < diff; i++) {
            sub.append("0");
        }
        if (a.length() > b.length()) {
            b = sub.append(b).toString();
        } else {
            a = sub.append(a).toString();
        }
        int carry = 0;
        int sum = 0;
        for (int i = a.length() - 1; i >= 0; --i) {
            int va = Integer.parseInt(String.valueOf(a.charAt(i)));
            int vb = Integer.parseInt(String.valueOf(b.charAt(i)));
            sum = va + vb + carry;
            if (sum >= 2) {
                carry = 1;
                sum = 0;
            }
            result.append(sum);
            if (i == 0 && carry != 0) {
                result.append(carry);
            }
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("addBinary  = " + addBinary("11111111", "101"));
    }
}
