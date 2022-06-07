/**
 * @author ning_mx
 * @date 18:23 2022/3/14
 * @desc
 */
package tree;

/**
 * @author ning_mx
 * @date 2022/3/14
 * 在一个二叉树里所有结点都在0-9的范围之类，从根结点到叶结点的路径表示一个数字。
 * 求二叉树里所有路径表示的数字之和。
 * 例如在图中的二叉树有三条从根结点到叶结点的路径，它们分别表示数字395、391和302，这三个数字之和是1088
 * 3
 * 9        0
 * 5    1          2
 */
public class 从根结点到叶结点的路径数字之和 {
    public static int rootToSubNodeSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        int left = rootToSubNodeSum(root.left, sum);
        int right = rootToSubNodeSum(root.right, sum);

        return left + right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(2);
        System.out.println(rootToSubNodeSum(root, 0));
    }

}
