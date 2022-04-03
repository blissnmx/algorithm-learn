/**
 * @author ning_mx
 * @date 11:13 2022/3/9
 * @desc
 */
package queue;

import Model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ning_mx
 * @date 2022/3/9
 * 给你一个二叉树，想象你站在该二叉树的右侧，从上到下你看到的节点构成二叉树的右侧试图。
 * 例如图中的二叉树的右侧视图包含8、10、7三个节点。
 * 请写一个函数返回二叉树的右侧视图节点的值
 *         8
 *      6     10
 *   5     7
 */
public class 二叉树的右侧视图 {
    public static List<Integer> findTreeRightViewNode(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> curQue = new LinkedList();
        Queue<TreeNode> nextQue = new LinkedList();
        curQue.offer(root);
        while (!curQue.isEmpty()){
            TreeNode parent = curQue.poll();
            if (parent.left != null) {
                nextQue.offer(parent.left);
            }
            if (parent.right != null) {
                nextQue.offer(parent.right);
            }
            if (curQue.isEmpty()) {
                //队列最后一个元素
                result.add(parent.val);
                curQue = nextQue;
                nextQue = new LinkedList<>();
            }

        }

        return result ;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(10);
         System.out.println(findTreeRightViewNode(root));
    }
}
