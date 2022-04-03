/**
 * @author ning_mx
 * @date 17:32 2022/3/8
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
 * @date 2022/3/8
 * 输入一棵二叉树，请找出二叉树中每一层的最大值。例如输入图中的二叉树，返回三层节点的最大值[3, 4, 9]。
 *      3
 *    4   2
 * 5   1     9
 */
public class 二叉树每层的最大值 {
    public static List<Integer> findTreeLevelMaxNode(TreeNode root) {
        ArrayList result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList<>();
        int cur = 0 , next = 0 ;
        if (root != null) {
            queue.offer(root);
            cur = 1;
        }
        int max = 0 ;
        while(!queue.isEmpty()){
            TreeNode parent = queue.poll();
            max = Math.max(max,parent.val);
            cur -- ;
            if (parent.left != null) {
                next ++ ;
                queue.offer(parent.left);
            }
            if (parent.right != null) {
                next ++ ;
                queue.offer(parent.right);
            }
            if(cur == 0 ){
                result.add(max);
                cur = next;
                next = 0 ;
                max = 0 ;
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
        System.out.println(findTreeLevelMaxNode(root));
    }
}
