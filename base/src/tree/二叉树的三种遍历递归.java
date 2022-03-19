/**
 * @author ning_mx
 * @date 14:52 2022/3/9
 * @desc
 */
package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ning_mx
 * @date 2022/3/9
 */
public class 二叉树的三种遍历递归 {

    /**
     * 先序遍历：根-左-右，root->left->right
     * 递归
     * root节点一定是第一个
     */
    public static List<Integer> preOrderdTraveral(TreeNode root,List<Integer> result) {
        if (root == null) {
            return result;
        }
        result.add(root.val);
        preOrderdTraveral(root.left,result);
        preOrderdTraveral(root.right,result);
        return result;
    }

    /**
     * 中序遍历：左-根-右，left->root->right
     * 递归
     * root节点在中间位置
     */
    public static List<Integer> midOrderdTraveral(TreeNode root,List<Integer> result) {
        if (root == null) {
            return result;
        }
        midOrderdTraveral(root.left, result);
        result.add(root.val);
        midOrderdTraveral(root.right, result);
        return result;
    }
    /**
     * 后序遍历：左-右-根，left->right->root
     * 递归
     * root节点一定在最后
     */
    public static List<Integer> lastOrderdTraveral(TreeNode root,List<Integer> result) {
        if (root == null) {
            return result;
        }
        lastOrderdTraveral(root.left, result);
        lastOrderdTraveral(root.right, result);
        result.add(root.val);
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
        //preOrderdTraveral(root, new ArrayList<>()).stream().forEach(System.out::println);
        //midOrderdTraveral(root, new ArrayList<>()).stream().forEach(System.out::println);
        lastOrderdTraveral(root, new ArrayList<>()).stream().forEach(System.out::println);
    }
}
