/**
 * @author ning_mx
 * @date 19:00 2022/3/8
 * @desc
 */
package queue;

import Model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ning_mx
 * @date 2022/3/8
 * 如何在一个二叉树中找出它最底层中最左边节点的值？
 * 假设二叉树中最少有一个节点。
 * 例如在图中的二叉树中最底层节点中最左边一个节点的值是5。
 *           8
 *      6        10
 *   5    7    9   11
 */
public class 二叉树最底层最左边的值 {
    /**
     * 找到最后一层，队列中的第一个节点
     */
    public static int findBottomLeftNode(TreeNode root) {
        if (root == null) {
            return -1;
        }
        Queue<TreeNode> curQue = new LinkedList();
        Queue<TreeNode> nextQue = new LinkedList();
        int result = 0 ;
        curQue.offer(root);
        while (!curQue.isEmpty()) {
            TreeNode parent = curQue.poll();
            if (parent.left != null) {
                nextQue.offer(parent.left);
            }
            if (parent.right != null) {
                nextQue.offer(parent.right);
            }
            if(curQue.isEmpty()){
                curQue = nextQue ;
                nextQue = new LinkedList<>();
                if(!curQue.isEmpty()){
                    result = curQue.peek().val;
                }
            }
        }
        return result ;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);
        System.out.println(findBottomLeftNode(root));
    }
}
