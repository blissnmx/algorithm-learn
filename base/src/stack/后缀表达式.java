/**
 * @author ning_mx
 * @date 17:43 2022/3/2
 * @desc
 */
package stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author ning_mx
 * @date 2022/3/2
 * 后缀表达式是一种算术表达式，它的操作符在操作数的后面。
 * 输入一个用字符串数组表示的后缀表达式，请输出该后缀表达式的计算结果。
 * 假设输入的一定是有效的后缀表达式。例如，后缀表达式["2", "1", "3", "*", "+"]对应的算术表达式是“2 + 1 * 3”，
 * 因此输出它的计算结果5。
 */
public class 后缀表达式 {
    /**
     * 后缀表达式遇到运算符时，计算最近的两个数字，得到计算结果与下一个运算符计算
     * 使用栈结构存运算数以及每次计算后的结果
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public static int caclRPN(String[] strs) {
        Set<String> chars = new HashSet<>();
        chars.addAll(Arrays.asList(new String[]{"+","-","*","/"}));
        Stack<Integer> stack = new Stack<>();
        for (String str : strs) {
            if (chars.contains(str)) {
                if(stack.empty() || stack.size()<2){
                    return 0;
                }
                Integer i = stack.pop();
                Integer j = stack.pop();
                stack.push(calc(i,j,str));
            }else{
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.peek() ;
    }

    public static int calc(int i, int j ,String oper) {
        switch (oper){
            case "+":
                return i+j;
            case "-":
                return i-j;
            case "*":
                return  i*j;
            case "/":
                return i/j;
            default:
                return  0 ;
        }
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"2", "1", "3", "*", "+"};
        System.out.println(caclRPN(strs));
    }
}
