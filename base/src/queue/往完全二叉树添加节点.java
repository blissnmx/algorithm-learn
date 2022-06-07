/**
 * @author ning_mx
 * @date 16:53 2022/3/8
 * @desc
 */
package queue;

import Model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ning_mx
 * @date 2022/3/8
 * 在完全二叉树里，除了最后一层之外其他层的节点都是满的（第n层有2n-1个节点）。
 * 最后一层的节点可能不满，该层所有的节点尽可能向左边靠拢
 * 广度优先遍历（根-左-右）得到子节点和不满的节点，从左到右以此放入队列，节点满时则从队列里删除，队列最前面的节点即为目标插入节点的父节点
 */
public class 往完全二叉树添加节点 {
    private TreeNode root;
    private Queue<TreeNode> queue;

    public 往完全二叉树添加节点(TreeNode root) {
        if (root == null) {
            return;
        }
        this.root = root;
        this.queue = new LinkedList<>();
        queue.offer(root);
        while (queue.peek().left != null && queue.peek().right != null) {
            queue.poll();
            queue.add(root.left);
            queue.add(root.right);
        }
    }

    public void insert(int val) {
        if (queue.isEmpty()) {
            return;
        }
        TreeNode newNode = new TreeNode(val);
        if (queue.peek().left == null) {
            queue.peek().left = newNode;
        } else {
            TreeNode parent = queue.poll();
            parent.right = newNode;
            queue.offer(parent.left);
            queue.offer(parent.right);
        }
    }
}
