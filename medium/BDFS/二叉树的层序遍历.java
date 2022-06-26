/**
 * @author ning_mx
 * @date 19:26 2022/6/26
 * @desc
 */
package medium.BDFS;

import org.junit.Test;
import tree.TreeNode;

import java.util.*;

/**
 * @author ning_mx
 * @date 2022/6/26
 */
public class 二叉树的层序遍历 {
    /**
     * 102. 二叉树的层序遍历
     * @param root
     */
    @Test
    public void levelOrder(Node root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return ;
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Node node = que.poll();
                list.add(node.val);
                if (node.left != null) {
                    que.offer(node.left);
                }
                if(node.right != null){
                    que.offer(node.right);
                }
            }
            result.add(list);
         }
    }

    /**
     * 107. 二叉树的层序遍历 II
     * 自底向上层次遍历，将每次遍历的行添加到列表最前面即可，
     */
    @Test
    public void levelOrderBottom(){
        tree.TreeNode root = new TreeNode(1);
        Queue<TreeNode> que = new LinkedList<>();
        List<List<Integer>> r = new ArrayList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                list.add(node.val);
                if(node.left != null ) que.offer(node.left);
                if(node.right != null) que.offer(node.right);
            }
            r.add(0,list);
        }

    }
}
