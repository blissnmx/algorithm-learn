/**
 * @author ning_mx
 * @date 14:34 2022/3/9
 * @desc
 */
package tree;

import javax.swing.plaf.IconUIResource;
import java.util.Stack;

/**
 * @author ning_mx
 * @date 2022/3/9
 * 一个二叉树的所有结点的值要么是0要么是
 * ，请剪除该二叉树中所有结点的值全都是0 的子树。
 * 例如，在剪除图（a）中二叉树中所有结点值都为0的子树之后的结果如图 （b）所示。
 * 1
 * 0       0
 * 0    0   0    1
 * （a)
 * 1
 * 0
 * 1
 * (b)
 */
public class 二叉树剪枝 {
    static int count = 0;

    public static TreeNode cutSubNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        System.out.println(count++ + " ----> " + root.val);
        root.left = cutSubNode(root.left);
        root.right = cutSubNode(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        TreeNode treeNode = cutSubNode(root);
        if (treeNode != null) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = treeNode;
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    System.out.println(cur.val);
                    stack.push(cur);
                    cur = cur.left;
                }
                TreeNode pop = stack.pop();
                cur = pop.right;
            }
        }
    }
}
