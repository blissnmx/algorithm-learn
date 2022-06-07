/**
 * @author ning_mx
 * @date 14:52 2022/3/9
 * @desc
 */
package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ning_mx
 * @date 2022/3/9
 * 假设root不为null
 */
public class 二叉树的三种遍历非递归 {

    /**
     * 先序遍历：每遍历一个节点就要使用这个节点，也就是符合后进先出的特点，用栈存储每次遍历的节点，在遍历下个节点前弹出已遍历的节点即可
     * 时间复杂度O(n)
     */
    public static List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                result.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode pop = stack.pop();
            cur = pop.right;
        }
        return result;
    }

    /**
     * 中序遍历：
     * 递归
     * root节点在中间位置
     */
    public static List<Integer> midOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode pop = stack.pop();
            result.add(pop.val);
            cur = pop.right;
        }
        return result;
    }

    /**
     * 后序遍历：
     * 递归
     * root节点一定在最后
     */
    public static List<Integer> lastOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode pop = stack.peek();
            if (pop.right != null && pop.right == pre) {
                TreeNode parent = stack.pop();
                result.add(parent.val);
                pre = parent;
            } else {
                if (pop.right != null) {
                    cur = pop.right;
                } else {
                    cur = stack.pop();
                    result.add(cur.val);
                    pre = cur;
                    cur = null;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        preOrderTraversal(root).stream().forEach(System.out::println);
        //midOrderTraversal(root).stream().forEach(System.out::println);
        //lastOrderTraversal(root).stream().forEach(System.out::println);
    }
}
