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
 * 输入一个表示小行星的数组，数组中每个数字的绝对值表示小行星的大小，数字的正负号表示小行星运动的方向，正号表示向右飞行，负号表示向左飞行。
 * 如果两个小行星相撞，体积较小的小行星将会爆炸最终消失，体积较大的小行星不受影响。
 * 如果相撞的两个小行星大小相同，它们都会爆炸。飞行方向相同的小行星永远不会相撞。
 * 求最终剩下的小行星。例如，假如有六个小行星[4, 5, -6, 4, 8, -5]，它们相撞之后最终剩下三个小行星[-6, 4, 8]。
 */
public class 小行星碰撞 {
    /**
     * 数字方向相反则相撞，小的消失，大的入栈，以此与栈顶元素判断，直到方向相同
     * 时间复杂度O(n)--每个元素最多入栈一次、出栈一次
     * 空间复杂度O(n)
     */
    public static Stack<Integer> palnetColide(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            if (stack.empty()) {
                stack.push(num);
            } else {
                Integer top = stack.peek();
                if ((top > 0 && num > 0) || (top < 0 && num < 0)) {
                    stack.push(num);
                } else {
                    while (!stack.empty() && num < 0 && Math.abs(num) > Math.abs(top)) {
                        top = stack.pop();
                    }
                    if (top < 0 && Math.abs(top) > Math.abs(num)) {
                        stack.push(num);
                    }
                    if (stack.empty()) {
                        stack.push(num);
                    }
                }
            }
        }
        return stack;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, -6, 4, 8, -5};
        Stack<Integer> ns = palnetColide(nums);
        ns.stream().forEach(System.out::println);
    }
}
